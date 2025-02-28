package paulevs.betternether.registry;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.EntityFactory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import paulevs.betternether.BetterNether;
import paulevs.betternether.BlocksHelper;
import paulevs.betternether.config.Configs;
import paulevs.betternether.entity.EntityChair;
import paulevs.betternether.entity.EntityFirefly;
import paulevs.betternether.entity.EntityFlyingPig;
import paulevs.betternether.entity.EntityHydrogenJellyfish;
import paulevs.betternether.entity.EntityJungleSkeleton;
import paulevs.betternether.entity.EntityNaga;
import paulevs.betternether.entity.EntityNagaProjectile;
import paulevs.betternether.entity.EntitySkull;
import ru.bclib.api.biomes.BiomeAPI;
import ru.bclib.api.spawning.SpawnRuleBuilder;
import ru.bclib.entity.BCLEntityWrapper;
import ru.bclib.interfaces.SpawnRule;
import ru.bclib.util.ColorUtil;

public class NetherEntities {
	public static final Map<EntityType<? extends Entity>, AttributeSupplier> ATTRIBUTES = Maps.newHashMap();
	private static final List<BCLEntityWrapper<?>> NETHER_ENTITIES = Lists.newArrayList();
	
	public static final EntityType<EntityChair> CHAIR = FabricEntityTypeBuilder.create(MobCategory.MISC, EntityChair::new)
																			   .dimensions(EntityDimensions.fixed(0.0F, 0.0F))
																			   .fireImmune()
																			   .disableSummon()
																			   .build();
	public static final EntityType<EntityNagaProjectile> NAGA_PROJECTILE = FabricEntityTypeBuilder.create(MobCategory.MISC, EntityNagaProjectile::new)
																								  .dimensions(EntityDimensions.fixed(1F, 1F))
																								  .disableSummon()
																								  .build();
	
	public static final BCLEntityWrapper<EntityFirefly> FIREFLY =
		register(
			"firefly",
			MobCategory.AMBIENT,
			0.5f,
			0.5f,
			EntityFirefly::new,
			EntityFirefly.createMobAttributes(),
			true,
			ColorUtil.color(255, 223, 168),
			ColorUtil.color(233, 182, 95)
		);
	
	public static final BCLEntityWrapper<EntityHydrogenJellyfish> HYDROGEN_JELLYFISH =
		register(
			"hydrogen_jellyfish",
			MobCategory.AMBIENT,
			2.0f,
			5.0f,
			EntityHydrogenJellyfish::new,
			EntityHydrogenJellyfish.createMobAttributes(),
			false,
			ColorUtil.color(253, 164, 24),
			ColorUtil.color(88, 21, 4)
		);
	
	public static final BCLEntityWrapper<EntityNaga> NAGA =
		register(
			"naga",
			MobCategory.MONSTER,
			0.625f,
			2.75f,
			EntityNaga::new,
			EntityNaga.createMobAttributes(),
			true,
			ColorUtil.color(12, 12, 12),
			ColorUtil.color(210, 90, 26)
		);
	
	public static final BCLEntityWrapper<EntityFlyingPig> FLYING_PIG =
		register(
			"flying_pig",
			MobCategory.AMBIENT,
			1.0f,
				1.25f,
			EntityFlyingPig::new,
			EntityFlyingPig.createMobAttributes(),
			true,
			ColorUtil.color(241, 140, 93),
			ColorUtil.color(176, 58, 47)
		);
	
	public static final BCLEntityWrapper<EntityJungleSkeleton> JUNGLE_SKELETON =
		register(
			"jungle_skeleton",
			MobCategory.MONSTER,
			0.6F,
			1.99F,
			EntityJungleSkeleton::new,
			EntityJungleSkeleton.createMonsterAttributes(),
			true,
			ColorUtil.color(134, 162, 149),
			ColorUtil.color(6, 111, 79)
		);
	
	public static final BCLEntityWrapper<EntitySkull> SKULL =
		register(
			"skull",
			MobCategory.MONSTER,
			0.625F,
			0.625F,
			EntitySkull::new,
			EntitySkull.createMobAttributes(),
			true,
			ColorUtil.color(24, 19, 19),
			ColorUtil.color(255, 28, 18)
		);
	
	
	private static <T extends Mob> BCLEntityWrapper<T> register(String name, MobCategory group, float width, float height, EntityFactory<T> entity, Builder attributes, boolean fixedSize, int eggColor, int dotsColor) {
		ResourceLocation id = BetterNether.makeID(name);
		EntityType<T> type = FabricEntityTypeBuilder.<T>create(group, entity)
													.dimensions(fixedSize ? EntityDimensions.fixed(width, height) : EntityDimensions.scalable(width, height))
													.fireImmune() //Nether Entities are by default immune to fire
													.build();
		
		type = Registry.register(Registry.ENTITY_TYPE, id, type);
		FabricDefaultAttributeRegistry.register(type, attributes);
		NetherItems.makeEgg("spawn_egg_" + name, type, eggColor, dotsColor);
		
		if (Configs.MOBS.getBooleanRoot(id.getPath(), true)) {
			return new BCLEntityWrapper<>(type, true);
		}
		
		var wrapper = new BCLEntityWrapper<>(type, false);
		NETHER_ENTITIES.add(wrapper);
		return wrapper;
	}
	
	private static boolean testSpawnAboveLava(LevelAccessor world, BlockPos pos, boolean allow){
		int h = ru.bclib.util.BlocksHelper.downRay(world, pos, MAX_FLOAT_HEIGHT+2);
		if  (h>MAX_FLOAT_HEIGHT) return false;
		
		for (int i = 1; i <= h+1; i++)
			if (BlocksHelper.isLava(world.getBlockState(pos.below(i))))
				return allow;
		
		return !allow;
	}
	
	public static final int MAX_FLOAT_HEIGHT = 7;
	public static final SpawnRule RULE_FLOAT_NOT_ABOVE_LAVA = (type, world, spawnReason, pos, random) -> testSpawnAboveLava(world, pos, false);
	public static final SpawnRule RULE_FLOAT_ABOVE_LAVA = (type, world, spawnReason, pos, random) -> testSpawnAboveLava(world, pos, true);
	
	
	public static void register() {
		registerEntity("chair", CHAIR, EntityChair.getAttributeContainer());
		registerEntity("naga_projectile", NAGA_PROJECTILE);
		
		SpawnRuleBuilder
			.start(FIREFLY)
			.belowMaxHeight()
			.customRule(RULE_FLOAT_NOT_ABOVE_LAVA)
			.maxNearby(32, 64)
			.buildNoRestrictions(Types.MOTION_BLOCKING_NO_LEAVES);
		
		SpawnRuleBuilder
			.start(HYDROGEN_JELLYFISH)
			.belowMaxHeight()
			.maxNearby(24, 64)
			.buildNoRestrictions(Types.MOTION_BLOCKING);
		
		SpawnRuleBuilder
			.start(NAGA)
			.hostile(8)
			.maxNearby(32, 64)
			.buildOnGround(Types.MOTION_BLOCKING_NO_LEAVES);
		
		SpawnRuleBuilder
			.start(FLYING_PIG)
			.belowMaxHeight()
			.customRule(RULE_FLOAT_NOT_ABOVE_LAVA)
			.maxNearby(16, 64)
			.buildNoRestrictions(Types.MOTION_BLOCKING);
		
		SpawnRuleBuilder
			.start(JUNGLE_SKELETON)
			.notPeaceful()
			.maxNearby(16, 64)
			.buildOnGround(Types.MOTION_BLOCKING_NO_LEAVES);
		
		SpawnRuleBuilder
			.start(SKULL)
			.belowMaxHeight()
			.vanillaHostile()
			.maxNearby(16, 64)
			.buildNoRestrictions(Types.MOTION_BLOCKING);
	}
	
	public static void registerEntity(String name, EntityType<? extends LivingEntity> entity) {
		Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(BetterNether.MOD_ID, name), entity);
		ATTRIBUTES.put(entity, Mob.createMobAttributes().build());
	}
	
	public static void registerEntity(String name, EntityType<? extends Entity> entity, AttributeSupplier container) {
		if (Configs.MOBS.getBoolean("mobs", name, true)) {
			Registry.register(Registry.ENTITY_TYPE, new ResourceLocation(BetterNether.MOD_ID, name), entity);
			ATTRIBUTES.put(entity, container);
		}
	}
	
	public static boolean isNetherEntity(Entity entity) {
		return NETHER_ENTITIES.contains(entity.getType());
	}
	
	static void modifyNonBNBiome(ResourceLocation biomeID, Biome biome) {
		BiomeAPI.addBiomeMobSpawn(biome, FIREFLY, 5, 3, 6);
		BiomeAPI.addBiomeMobSpawn(biome, HYDROGEN_JELLYFISH, 5, 2, 5);
		BiomeAPI.addBiomeMobSpawn(biome, NAGA, 8, 3, 5);
	}
}
