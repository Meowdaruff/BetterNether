package paulevs.betternether.world.biomes;

import java.util.Random;
import java.util.function.BiFunction;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import paulevs.betternether.BlocksHelper;
import paulevs.betternether.registry.NetherBlocks;
import paulevs.betternether.world.NetherBiome;
import paulevs.betternether.world.NetherBiomeBuilder;
import paulevs.betternether.world.NetherBiomeConfig;
import paulevs.betternether.world.structures.StructureType;
import paulevs.betternether.world.structures.plants.StructureBlackApple;
import paulevs.betternether.world.structures.plants.StructureBlackBush;
import paulevs.betternether.world.structures.plants.StructureInkBush;
import paulevs.betternether.world.structures.plants.StructureMagmaFlower;
import paulevs.betternether.world.structures.plants.StructureNetherGrass;
import paulevs.betternether.world.structures.plants.StructureNetherWart;
import paulevs.betternether.world.structures.plants.StructureReeds;
import paulevs.betternether.world.structures.plants.StructureSmoker;
import paulevs.betternether.world.structures.plants.StructureWartSeed;
import ru.bclib.api.biomes.BCLBiomeBuilder;
import ru.bclib.api.biomes.BCLBiomeBuilder.BiomeSupplier;
import ru.bclib.world.biomes.BCLBiomeSettings;

public class NetherPoorGrasslands extends NetherBiome {
	public static class Config extends NetherBiomeConfig {
		public Config(String name) {
			super(name);
		}
		
		@Override
		protected void addCustomBuildData(BCLBiomeBuilder builder) {
			builder.fogColor(113, 73, 133)
				   .loop(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
				   .additions(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS)
				   .mood(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD)
				   .structure(NetherBiomeBuilder.VANILLA_STRUCTURES.getBASTION_REMNANT())
				   .structure(NetherBiomeBuilder.VANILLA_STRUCTURES.getNETHER_BRIDGE())
				   .genChance(0.3F);
		}
		
		@Override
		public BiomeSupplier<NetherBiome> getSupplier() {
			return NetherPoorGrasslands::new;
		}
	}
	
	public NetherPoorGrasslands(ResourceLocation biomeID, Biome biome, BCLBiomeSettings settings) {
		super(biomeID, biome, settings);
	}
	
	@Override
	protected void onInit(){
		addStructure("nether_reed", new StructureReeds(), StructureType.FLOOR, 0.05F, false);
		addStructure("nether_wart", new StructureNetherWart(), StructureType.FLOOR, 0.005F, true);
		addStructure("magma_flower", new StructureMagmaFlower(), StructureType.FLOOR, 0.05F, true);
		addStructure("smoker", new StructureSmoker(), StructureType.FLOOR, 0.005F, true);
		addStructure("ink_bush", new StructureInkBush(), StructureType.FLOOR, 0.005F, true);
		addStructure("black_apple", new StructureBlackApple(), StructureType.FLOOR, 0.001F, true);
		addStructure("black_bush", new StructureBlackBush(), StructureType.FLOOR, 0.002F, true);
		addStructure("wart_seed", new StructureWartSeed(), StructureType.FLOOR, 0.002F, true);
		addStructure("nether_grass", new StructureNetherGrass(), StructureType.FLOOR, 0.04F, true);
	}

	@Override
	public void genSurfColumn(LevelAccessor world, BlockPos pos, Random random) {
		switch (random.nextInt(3)) {
			case 0:
				BlocksHelper.setWithoutUpdate(world, pos, Blocks.SOUL_SOIL.defaultBlockState());
				break;
			case 1:
				BlocksHelper.setWithoutUpdate(world, pos, NetherBlocks.NETHERRACK_MOSS.defaultBlockState());
				break;
			default:
				super.genSurfColumn(world, pos, random);
				break;
		}
		for (int i = 1; i < random.nextInt(3); i++) {
			BlockPos down = pos.below(i);
			if (random.nextInt(3) == 0 && BlocksHelper.isNetherGround(world.getBlockState(down))) {
				BlocksHelper.setWithoutUpdate(world, down, Blocks.SOUL_SAND.defaultBlockState());
			}
		}
	}
}