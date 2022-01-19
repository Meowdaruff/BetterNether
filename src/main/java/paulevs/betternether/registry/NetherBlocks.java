package paulevs.betternether.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock.Sensitivity;
import net.minecraft.world.level.material.MaterialColor;
import org.jetbrains.annotations.NotNull;
import paulevs.betternether.BetterNether;
import paulevs.betternether.blocks.BNBarStool;
import paulevs.betternether.blocks.BNBoneBlock;
import paulevs.betternether.blocks.BNBrewingStand;
import paulevs.betternether.blocks.BNChain;
import paulevs.betternether.blocks.BNGlass;
import paulevs.betternether.blocks.BNLeaves;
import paulevs.betternether.blocks.BNNetherBrick;
import paulevs.betternether.blocks.BNNormalChair;
import paulevs.betternether.blocks.BNObsidian;
import paulevs.betternether.blocks.BNPane;
import paulevs.betternether.blocks.BNPillar;
import paulevs.betternether.blocks.BNTaburet;
import paulevs.betternether.blocks.BNWall;
import paulevs.betternether.blocks.BlockAgave;
import paulevs.betternether.blocks.BlockAnchorTreeVine;
import paulevs.betternether.blocks.BlockBNPot;
import paulevs.betternether.blocks.BlockBarrelCactus;
import paulevs.betternether.blocks.BlockBase;
import paulevs.betternether.blocks.BlockBlackApple;
import paulevs.betternether.blocks.BlockBlackAppleSeed;
import paulevs.betternether.blocks.BlockBlackBush;
import paulevs.betternether.blocks.BlockBlackVine;
import paulevs.betternether.blocks.BlockBoneMushroom;
import paulevs.betternether.blocks.BlockBrownLargeMushroom;
import paulevs.betternether.blocks.BlockChestOfDrawers;
import paulevs.betternether.blocks.BlockCincinnasitPillar;
import paulevs.betternether.blocks.BlockCincinnasite;
import paulevs.betternether.blocks.BlockCincinnasiteAnvil;
import paulevs.betternether.blocks.BlockCincinnasiteForge;
import paulevs.betternether.blocks.BlockCincinnasiteFrame;
import paulevs.betternether.blocks.BlockCincinnasiteLantern;
import paulevs.betternether.blocks.BlockCincinnasitePedestal;
import paulevs.betternether.blocks.BlockEggPlant;
import paulevs.betternether.blocks.BlockEyeSeed;
import paulevs.betternether.blocks.BlockEyeVine;
import paulevs.betternether.blocks.BlockEyeball;
import paulevs.betternether.blocks.BlockEyeballSmall;
import paulevs.betternether.blocks.BlockFarmland;
import paulevs.betternether.blocks.BlockFeatherFern;
import paulevs.betternether.blocks.BlockFireBowl;
import paulevs.betternether.blocks.BlockGeyser;
import paulevs.betternether.blocks.BlockGiantLucis;
import paulevs.betternether.blocks.BlockGiantMold;
import paulevs.betternether.blocks.BlockGiantMoldSapling;
import paulevs.betternether.blocks.BlockGoldenVine;
import paulevs.betternether.blocks.BlockGrayMold;
import paulevs.betternether.blocks.BlockHookMushroom;
import paulevs.betternether.blocks.BlockInkBush;
import paulevs.betternether.blocks.BlockInkBushSeed;
import paulevs.betternether.blocks.BlockJellyfishMushroom;
import paulevs.betternether.blocks.BlockJellyfishMushroomSapling;
import paulevs.betternether.blocks.BlockLucisMushroom;
import paulevs.betternether.blocks.BlockLucisSpore;
import paulevs.betternether.blocks.BlockLumabusSeed;
import paulevs.betternether.blocks.BlockLumabusVine;
import paulevs.betternether.blocks.BlockMagmaFlower;
import paulevs.betternether.blocks.BlockMossCover;
import paulevs.betternether.blocks.BlockNeonEquisetum;
import paulevs.betternether.blocks.BlockNetherCactus;
import paulevs.betternether.blocks.BlockNetherFurnace;
import paulevs.betternether.blocks.BlockNetherGrass;
import paulevs.betternether.blocks.BlockNetherMycelium;
import paulevs.betternether.blocks.BlockNetherRuby;
import paulevs.betternether.blocks.BlockNetherSakuraLeaves;
import paulevs.betternether.blocks.BlockObsidianGlass;
import paulevs.betternether.blocks.BlockOrangeMushroom;
import paulevs.betternether.blocks.BlockOre;
import paulevs.betternether.blocks.BlockPlantWall;
import paulevs.betternether.blocks.BlockPottedPlant;
import paulevs.betternether.blocks.BlockRedLargeMushroom;
import paulevs.betternether.blocks.BlockRedMold;
import paulevs.betternether.blocks.BlockRubeusLeaves;
import paulevs.betternether.blocks.BlockSmallLantern;
import paulevs.betternether.blocks.BlockSmoker;
import paulevs.betternether.blocks.BlockSoulGrass;
import paulevs.betternether.blocks.BlockSoulLily;
import paulevs.betternether.blocks.BlockSoulLilySapling;
import paulevs.betternether.blocks.BlockSoulSandstone;
import paulevs.betternether.blocks.BlockSoulVein;
import paulevs.betternether.blocks.BlockStalactite;
import paulevs.betternether.blocks.BlockStatueRespawner;
import paulevs.betternether.blocks.BlockTerrain;
import paulevs.betternether.blocks.BlockVeinedSand;
import paulevs.betternether.blocks.BlockWhisperingGourd;
import paulevs.betternether.blocks.BlockWhisperingGourdLantern;
import paulevs.betternether.blocks.BlockWhisperingGourdVine;
import paulevs.betternether.blocks.BlockWillowLeaves;
import paulevs.betternether.blocks.BlueCryingObsidianBlock;
import paulevs.betternether.blocks.BlueWeepingObsidianBlock;
import paulevs.betternether.blocks.RedstoneOreBlock;
import paulevs.betternether.blocks.VanillaWeepingObsidianBlock;
import paulevs.betternether.blocks.complex.AnchorTreeMaterial;
import paulevs.betternether.blocks.complex.ColoredGlassMaterial;
import paulevs.betternether.blocks.complex.MushroomFirMaterial;
import paulevs.betternether.blocks.complex.NetherMushroomMaterial;
import paulevs.betternether.blocks.complex.NetherReedMaterial;
import paulevs.betternether.blocks.complex.NetherSakuraMaterial;
import paulevs.betternether.blocks.complex.NetherWoodenMaterial;
import paulevs.betternether.blocks.complex.RubeusMaterial;
import paulevs.betternether.blocks.complex.StalagnateMaterial;
import paulevs.betternether.blocks.complex.WartMaterial;
import paulevs.betternether.blocks.complex.WillowMaterial;
import paulevs.betternether.config.Configs;
import paulevs.betternether.recipes.RecipesHelper;
import paulevs.betternether.structures.plants.StructureGoldenLumabusVine;
import paulevs.betternether.structures.plants.StructureLumabusVine;
import paulevs.betternether.tab.CreativeTabs;
import ru.bclib.api.TagAPI;
import ru.bclib.blocks.BaseBarrelBlock;
import ru.bclib.blocks.BaseChestBlock;
import ru.bclib.blocks.BaseCraftingTableBlock;
import ru.bclib.blocks.BaseDoorBlock;
import ru.bclib.blocks.BaseLadderBlock;
import ru.bclib.blocks.BasePressurePlateBlock;
import ru.bclib.blocks.BaseSlabBlock;
import ru.bclib.blocks.BaseStairsBlock;
import ru.bclib.blocks.BaseWoodenButtonBlock;
import ru.bclib.recipes.GridRecipe;
import ru.bclib.registry.BlockRegistry;

import java.util.List;

public class NetherBlocks extends ru.bclib.registry.BlockRegistry {
	// Stalagnate //
	public static final StalagnateMaterial MAT_STALAGNATE = new StalagnateMaterial().init();
	
	// Willow //
	public static final WillowMaterial MAT_WILLOW = new WillowMaterial().init();
	public static final Block WILLOW_LEAVES = registerBlock("willow_leaves", new BlockWillowLeaves(MAT_WILLOW.getSapling()));
	
	// Rubeus //
	public static final RubeusMaterial MAT_RUBEUS = new RubeusMaterial().init();
	public static final Block RUBEUS_LEAVES = registerBlock("rubeus_leaves", new BlockRubeusLeaves(MAT_RUBEUS.getSapling()));
	
	// Reed //
	public static final NetherReedMaterial MAT_REED = new NetherReedMaterial().init();
	
	// Wart //
	public static final WartMaterial MAT_WART = new WartMaterial("wart", MaterialColor.COLOR_RED, MaterialColor.COLOR_RED).init();
	
	// Mushroom Fir //
	public static final MushroomFirMaterial MAT_MUSHROOM_FIR = new MushroomFirMaterial().init();
	
	// Mushroom //
	public static final NetherMushroomMaterial MAT_NETHER_MUSHROOM = new NetherMushroomMaterial().init();
	
	// Anchor Tree
	public static final AnchorTreeMaterial MAT_ANCHOR_TREE = new AnchorTreeMaterial().init();
	public static final Block ANCHOR_TREE_LEAVES = registerBlock("anchor_tree_leaves", new BNLeaves(MAT_ANCHOR_TREE.getSapling(), MaterialColor.COLOR_GREEN));
	public static final Block ANCHOR_TREE_VINE = registerBlockNI("anchor_tree_vine", new BlockAnchorTreeVine());
	
	
	// Nether Sakura
	public static final NetherSakuraMaterial MAT_NETHER_SAKURA = new NetherSakuraMaterial().init();
	public static final Block NETHER_SAKURA_LEAVES = registerBlock("nether_sakura_leaves", new BlockNetherSakuraLeaves(MAT_NETHER_SAKURA.getSapling()));
	
	
	// Cincinnasite //
	public static final Block CINCINNASITE_ORE = registerBlock("cincinnasite_ore", new BlockOre(NetherItems.CINCINNASITE, 1, 3,0));
	public static final Block CINCINNASITE_BLOCK = registerBlock("cincinnasite_block", new BlockCincinnasite());
	public static final Block CINCINNASITE_FORGED = registerBlock("cincinnasite_forged", new BlockCincinnasite());
	public static final Block CINCINNASITE_PILLAR = registerBlock("cincinnasite_pillar", new BlockCincinnasitPillar());
	public static final Block CINCINNASITE_BRICKS = registerBlock("cincinnasite_bricks", new BlockCincinnasite());
	public static final Block CINCINNASITE_BRICK_PLATE = registerBlock("cincinnasite_brick_plate", new BlockCincinnasite());
	public static final Block CINCINNASITE_STAIRS = registerStairs("cincinnasite_stairs", CINCINNASITE_FORGED);
	public static final Block CINCINNASITE_SLAB = registerSlab("cincinnasite_slab", CINCINNASITE_FORGED);
	public static final Block CINCINNASITE_BUTTON = registerBlock("cincinnasite_button", new BaseWoodenButtonBlock(CINCINNASITE_FORGED));
	public static final Block CINCINNASITE_PLATE = registerPlate("cincinnasite_plate", CINCINNASITE_FORGED, Sensitivity.MOBS);
	public static final Block CINCINNASITE_LANTERN = registerBlock("cincinnasite_lantern", new BlockCincinnasiteLantern());
	public static final Block CINCINNASITE_TILE_LARGE = registerBlock("cincinnasite_tile_large", new BlockCincinnasite());
	public static final Block CINCINNASITE_TILE_SMALL = registerBlock("cincinnasite_tile_small", new BlockCincinnasite());
	public static final Block CINCINNASITE_CARVED = registerBlock("cincinnasite_carved", new BlockCincinnasite());
	public static final Block CINCINNASITE_WALL = registerWall("cincinnasite_wall", CINCINNASITE_FORGED);
	public static final Block CINCINNASITE_BRICKS_PILLAR = registerBlock("cincinnasite_bricks_pillar", new BNPillar(CINCINNASITE_FORGED));
	public static final Block CINCINNASITE_BARS = registerBlock("cincinnasite_bars", new BNPane(CINCINNASITE_FORGED, true));
	public static final Block CINCINNASITE_PEDESTAL = registerBlock("cincinnasite_pedestal", new BlockCincinnasitePedestal());
	public static final Block CINCINNASITE_FRAME = registerBlock("cincinnasite_frame", new BlockCincinnasiteFrame());
	public static final Block CINCINNASITE_LANTERN_SMALL = registerBlock("cincinnasite_lantern_small", new BlockSmallLantern());
	public static final Block CINCINNASITE_CHAIN = registerBlock("cincinnasite_chain", new BNChain());
	
	// Ruby //
	public static final Block NETHER_RUBY_ORE = registerBlock("nether_ruby_ore", new BlockOre(NetherItems.NETHER_RUBY, 1, 2, 5));
	public static final Block NETHER_RUBY_BLOCK = registerBlock("nether_ruby_block", new BlockNetherRuby());
	public static final Block NETHER_RUBY_STAIRS = registerStairs("nether_ruby_stairs", NETHER_RUBY_BLOCK);
	public static final Block NETHER_RUBY_SLAB = registerSlab("nether_ruby_slab", NETHER_RUBY_BLOCK);
	
	// Vanilla Ores
	public static final Block NETHER_LAPIS_ORE = registerBlock("nether_lapis_ore", new BlockOre(NetherItems.LAPIS_PILE, 3, 6, 3));
	public static final Block NETHER_REDSTONE_ORE = registerBlock("nether_redstone_ore", new RedstoneOreBlock());
	
	
	// Bricks //
	public static final Block NETHER_BRICK_TILE_LARGE = registerBlock("nether_brick_tile_large", new BNNetherBrick());
	public static final Block NETHER_BRICK_TILE_SMALL = registerBlock("nether_brick_tile_small", new BNNetherBrick());
	public static final Block NETHER_BRICK_WALL = registerWall("nether_brick_wall", NETHER_BRICK_TILE_LARGE);
	public static final Block NETHER_BRICK_TILE_SLAB = registerSlab("nether_brick_tile_slab", NETHER_BRICK_TILE_SMALL);
	public static final Block NETHER_BRICK_TILE_STAIRS = registerStairs("nether_brick_tile_stairs", NETHER_BRICK_TILE_SMALL);
	
	// Bone //
	public static final Block BONE_BLOCK = registerBlock("bone_block", new BNBoneBlock());
	public static final Block BONE_STAIRS = registerStairs("bone_stairs", BONE_BLOCK);
	public static final Block BONE_SLAB = registerSlab("bone_slab", BONE_BLOCK);
	public static final Block BONE_BUTTON = registerButton("bone_button", BONE_BLOCK);
	public static final Block BONE_PLATE = registerPlate("bone_plate", BONE_BLOCK);
	public static final Block BONE_WALL = registerWall("bone_wall", BONE_BLOCK);
	public static final Block BONE_TILE = registerBlock("bone_tile", new BNBoneBlock());
	public static final Block BONE_REED_DOOR = registerBlock("bone_reed_door", new BaseDoorBlock(BONE_BLOCK));
	public static final Block BONE_CINCINNASITE_DOOR = registerBlock("bone_cincinnasite_door", new BaseDoorBlock(BONE_BLOCK));
	
	// Quartz Glass //
	public static final Block QUARTZ_GLASS = registerBlock("quartz_glass", new BNGlass(Blocks.GLASS));
	public static final Block QUARTZ_GLASS_FRAMED = registerBlock("quartz_glass_framed", new BNGlass(CINCINNASITE_BLOCK));
	public static final Block QUARTZ_GLASS_PANE = registerBlock("quartz_glass_pane", new BNPane(QUARTZ_GLASS, true));
	public static final Block QUARTZ_GLASS_FRAMED_PANE = registerBlock("quartz_glass_framed_pane", new BNPane(CINCINNASITE_BLOCK, true));
	
	// Quartz Glass Colored //
	public static final ColoredGlassMaterial QUARTZ_GLASS_COLORED = new ColoredGlassMaterial("quartz_glass", QUARTZ_GLASS);
	public static final ColoredGlassMaterial QUARTZ_GLASS_FRAMED_COLORED = new ColoredGlassMaterial("quartz_glass_framed", QUARTZ_GLASS_FRAMED);
	public static final ColoredGlassMaterial QUARTZ_GLASS_PANE_COLORED = new ColoredGlassMaterial("quartz_glass_pane", QUARTZ_GLASS_PANE, false);
	public static final ColoredGlassMaterial QUARTZ_GLASS_FRAMED_PANE_COLORED = new ColoredGlassMaterial("quartz_glass_framed_pane", QUARTZ_GLASS_FRAMED_PANE, true);
	
	// Obsidian //
	public static final Block BLUE_WEEPING_OBSIDIAN = registerBlock("blue_weeping_obsidian", new BlueWeepingObsidianBlock(), TagAPI.BLOCK_IMMOBILE);
	public static final Block WEEPING_OBSIDIAN = registerBlock("weeping_obsidian", new VanillaWeepingObsidianBlock(), TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_CRYING_OBSIDIAN = registerBlock("blue_crying_obsidian", new BlueCryingObsidianBlock(), TagAPI.BLOCK_IMMOBILE);
	
	public static final Block OBSIDIAN_BRICKS = registerBlock("obsidian_bricks", new BNObsidian(), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block OBSIDIAN_BRICKS_STAIRS = registerStairs("obsidian_bricks_stairs", OBSIDIAN_BRICKS, TagAPI.BLOCK_IMMOBILE);
	public static final Block OBSIDIAN_BRICKS_SLAB = registerSlab("obsidian_bricks_slab", OBSIDIAN_BRICKS, TagAPI.BLOCK_IMMOBILE);
	public static final Block OBSIDIAN_TILE = registerBlock("obsidian_tile", new BNObsidian(), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block OBSIDIAN_TILE_SMALL = registerBlock("obsidian_tile_small", new BNObsidian(), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block OBSIDIAN_TILE_STAIRS = registerStairs("obsidian_tile_stairs", OBSIDIAN_TILE_SMALL, TagAPI.BLOCK_IMMOBILE);
	public static final Block OBSIDIAN_TILE_SLAB = registerSlab("obsidian_tile_slab", OBSIDIAN_TILE_SMALL, TagAPI.BLOCK_IMMOBILE);
	public static final Block OBSIDIAN_ROD_TILES = registerBlock("obsidian_rod_tiles", new BNObsidian(), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block OBSIDIAN_GLASS = registerBlock("obsidian_glass", new BlockObsidianGlass(), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block OBSIDIAN_GLASS_PANE = registerBlock("obsidian_glass_pane", new BNPane(OBSIDIAN_GLASS, true));
	public static final Block BLUE_OBSIDIAN = registerBlock("blue_obsidian", new BNObsidian(BLUE_CRYING_OBSIDIAN), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_OBSIDIAN_BRICKS = registerBlock("blue_obsidian_bricks", new BNObsidian(), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_OBSIDIAN_BRICKS_STAIRS = registerStairs("blue_obsidian_bricks_stairs", BLUE_OBSIDIAN_BRICKS, TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_OBSIDIAN_BRICKS_SLAB = registerSlab("blue_obsidian_bricks_slab", BLUE_OBSIDIAN_BRICKS, TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_OBSIDIAN_TILE = registerBlock("blue_obsidian_tile", new BNObsidian(), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_OBSIDIAN_TILE_SMALL = registerBlock("blue_obsidian_tile_small", new BNObsidian(), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_OBSIDIAN_TILE_STAIRS = registerStairs("blue_obsidian_tile_stairs", BLUE_OBSIDIAN_TILE_SMALL, TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_OBSIDIAN_TILE_SLAB = registerSlab("blue_obsidian_tile_slab", BLUE_OBSIDIAN_TILE_SMALL, TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_OBSIDIAN_ROD_TILES = registerBlock("blue_obsidian_rod_tiles", new BNObsidian(), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_OBSIDIAN_GLASS = registerBlock("blue_obsidian_glass", new BlockObsidianGlass(), TagAPI.BLOCK_NETHER_PORTAL_FRAME, TagAPI.BLOCK_IMMOBILE);
	public static final Block BLUE_OBSIDIAN_GLASS_PANE = registerBlock("blue_obsidian_glass_pane", new BNPane(BLUE_OBSIDIAN_GLASS, true));
	
	// Soul Sandstone //
	public static final Block SOUL_SANDSTONE = registerMakeable2X2Soul("soul_sandstone", new BlockSoulSandstone(), "soul_sandstone", Blocks.SOUL_SAND);
	public static final Block SOUL_SANDSTONE_CUT = registerMakeable2X2Soul("soul_sandstone_cut", new BlockSoulSandstone(), "soul_sandstone", SOUL_SANDSTONE);
	public static final Block SOUL_SANDSTONE_SMOOTH = registerSoulBlock("soul_sandstone_smooth", new BlockBase(FabricBlockSettings.copyOf(Blocks.SANDSTONE)));
	public static final Block SOUL_SANDSTONE_CHISELED = registerMakeable2X2Soul("soul_sandstone_chiseled", new BlockBase(FabricBlockSettings.copyOf(Blocks.SANDSTONE)), "soul_sandstone", SOUL_SANDSTONE_SMOOTH);
	
	public static final Block SOUL_SANDSTONE_STAIRS = registerStairs("soul_sandstone_stairs", SOUL_SANDSTONE, BlockTags.SOUL_SPEED_BLOCKS, BlockTags.SOUL_FIRE_BASE_BLOCKS);
	public static final Block SOUL_SANDSTONE_CUT_STAIRS = registerStairs("soul_sandstone_cut_stairs", SOUL_SANDSTONE_CUT, BlockTags.SOUL_SPEED_BLOCKS, BlockTags.SOUL_FIRE_BASE_BLOCKS);
	public static final Block SOUL_SANDSTONE_SMOOTH_STAIRS = registerStairs("soul_sandstone_smooth_stairs", SOUL_SANDSTONE_SMOOTH, BlockTags.SOUL_SPEED_BLOCKS, BlockTags.SOUL_FIRE_BASE_BLOCKS);
	
	public static final Block SOUL_SANDSTONE_SLAB = registerSlab("soul_sandstone_slab", SOUL_SANDSTONE);
	public static final Block SOUL_SANDSTONE_CUT_SLAB = registerSlab("soul_sandstone_cut_slab", SOUL_SANDSTONE_CUT);
	public static final Block SOUL_SANDSTONE_SMOOTH_SLAB = registerSlab("soul_sandstone_smooth_slab", SOUL_SANDSTONE_SMOOTH);
	
	public static final Block SOUL_SANDSTONE_WALL = registerWall("soul_sandstone_wall", SOUL_SANDSTONE_CUT);
	
	// Basalt Bricks //
	public static final Block BASALT_BRICKS = registerMakeable2X2("basalt_bricks", new BlockBase(FabricBlockSettings.copyOf(Blocks.BASALT)), "basalt_bricks", Blocks.POLISHED_BASALT);
	public static final Block BASALT_BRICKS_STAIRS = registerStairs("basalt_bricks_stairs", BASALT_BRICKS);
	public static final Block BASALT_BRICKS_SLAB = registerSlab("basalt_bricks_slab", BASALT_BRICKS);
	public static final Block BASALT_BRICKS_WALL = registerWall("basalt_bricks_wall", BASALT_BRICKS);
	public static final Block BASALT_SLAB = registerSlab("basalt_slab", Blocks.BASALT);
	
	// Soul lily //
	public static final Block SOUL_LILY = registerBlockNI("soul_lily", new BlockSoulLily());
	public static final Block SOUL_LILY_SAPLING = registerBlock("soul_lily_sapling", new BlockSoulLilySapling());
	
	// Large & Small Mushrooms //
	public static final Block RED_LARGE_MUSHROOM = registerBlockNI("red_large_mushroom", new BlockRedLargeMushroom());
	public static final Block BROWN_LARGE_MUSHROOM = registerBlockNI("brown_large_mushroom", new BlockBrownLargeMushroom());
	public static final Block ORANGE_MUSHROOM = registerBlock("orange_mushroom", new BlockOrangeMushroom());
	public static final Block RED_MOLD = registerBlock("red_mold", new BlockRedMold());
	public static final Block GRAY_MOLD = registerBlock("gray_mold", new BlockGrayMold());
	
	// Lucis //
	public static final Block LUCIS_MUSHROOM = registerBlockNI("lucis_mushroom", new BlockLucisMushroom());
	public static final Block LUCIS_SPORE = registerBlock("lucis_spore", new BlockLucisSpore());
	public static final Block GIANT_LUCIS = registerBlock("giant_lucis", new BlockGiantLucis());
	
	// Giant Mold //
	public static final Block GIANT_MOLD = registerBlockNI("giant_mold", new BlockGiantMold());
	public static final Block GIANT_MOLD_SAPLING = registerBlock("giant_mold_sapling", new BlockGiantMoldSapling());
	
	public static final Block JELLYFISH_MUSHROOM = registerBlockNI("jellyfish_mushroom", new BlockJellyfishMushroom());
	public static final Block JELLYFISH_MUSHROOM_SAPLING = registerBlock("jellyfish_mushroom_sapling", new BlockJellyfishMushroomSapling());
	
	
	// Eyes //
	public static final Block EYEBALL = registerBlockNI("eyeball", new BlockEyeball());
	public static final Block EYEBALL_SMALL = registerBlockNI("eyeball_small", new BlockEyeballSmall());
	public static final Block EYE_VINE = registerBlockNI("eye_vine", new BlockEyeVine());
	public static final Block EYE_SEED = registerBlock("eye_seed", new BlockEyeSeed());
	
	// Grass //
	public static final Block NETHER_GRASS = registerBlock("nether_grass", new BlockNetherGrass());
	public static final Block SWAMP_GRASS = registerBlock("swamp_grass", new BlockNetherGrass());
	public static final Block SOUL_GRASS = registerBlock("soul_grass", new BlockSoulGrass());
	public static final Block JUNGLE_PLANT = registerBlock("jungle_plant", new BlockNetherGrass());
	public static final Block BONE_GRASS = registerBlock("bone_grass", new BlockNetherGrass());
	public static final Block SEPIA_BONE_GRASS = registerBlock("sepia_bone_grass", new BlockNetherGrass());
	
	// Vines //
	public static final Block BLACK_VINE = registerBlock("black_vine", new BlockBlackVine());
	public static final Block BLOOMING_VINE = registerBlock("blooming_vine", new BlockBlackVine());
	public static final Block GOLDEN_VINE = registerBlock("golden_vine", new BlockGoldenVine());
	public static final Block LUMABUS_SEED = registerBlock("lumabus_seed", new BlockLumabusSeed(new StructureLumabusVine()));
	public static final Block LUMABUS_VINE = registerBlockNI("lumabus_vine", new BlockLumabusVine(LUMABUS_SEED));
	public static final Block GOLDEN_LUMABUS_SEED = registerBlock("golden_lumabus_seed", new BlockLumabusSeed(new StructureGoldenLumabusVine()));
	public static final Block GOLDEN_LUMABUS_VINE = registerBlockNI("golden_lumabus_vine", new BlockLumabusVine(GOLDEN_LUMABUS_SEED));
	
	// Small Plants
	public static final Block SOUL_VEIN = registerBlock("soul_vein", new BlockSoulVein());
	public static final Block BONE_MUSHROOM = registerBlock("bone_mushroom", new BlockBoneMushroom());
	public static final Block BLACK_BUSH = registerBlock("black_bush", new BlockBlackBush());
	public static final Block INK_BUSH = registerBlockNI("ink_bush", new BlockInkBush());
	public static final Block INK_BUSH_SEED = registerBlock("ink_bush_seed", new BlockInkBushSeed());
	public static final Block SMOKER = registerBlock("smoker", new BlockSmoker());
	public static final Block EGG_PLANT = registerBlock("egg_plant", new BlockEggPlant());
	public static final Block BLACK_APPLE = registerBlockNI("black_apple", new BlockBlackApple());
	public static final Block BLACK_APPLE_SEED = registerBlock("black_apple_seed", new BlockBlackAppleSeed());
	public static final Block MAGMA_FLOWER = registerBlock("magma_flower", new BlockMagmaFlower());
	public static final Block FEATHER_FERN = registerBlock("feather_fern", new BlockFeatherFern());
	public static final Block MOSS_COVER = registerBlock("moss_cover", new BlockMossCover());
	public static final Block NEON_EQUISETUM = registerBlock("neon_equisetum", new BlockNeonEquisetum());
	public static final Block HOOK_MUSHROOM = registerBlock("hook_mushroom", new BlockHookMushroom());
	public static final Block WHISPERING_GOURD_VINE = registerBlock("whispering_gourd_vine", new BlockWhisperingGourdVine());
	public static final Block WHISPERING_GOURD = registerBlock("whispering_gourd", new BlockWhisperingGourd());
	public static final Block WHISPERING_GOURD_LANTERN = registerBlock("whispering_gourd_lantern", new BlockWhisperingGourdLantern());
	
	// Cactuses //
	public static final Block AGAVE = registerBlock("agave", new BlockAgave());
	public static final Block BARREL_CACTUS = registerBlock("barrel_cactus", new BlockBarrelCactus());
	public static final Block NETHER_CACTUS = registerBlock("nether_cactus", new BlockNetherCactus());
	
	// Wall plants
	public static final Block WALL_MOSS = registerBlock("wall_moss", new BlockPlantWall(MaterialColor.COLOR_RED));
	public static final Block WALL_MUSHROOM_BROWN = registerBlock("wall_mushroom_brown", new BlockPlantWall(MaterialColor.COLOR_BROWN));
	public static final Block WALL_MUSHROOM_RED = registerBlock("wall_mushroom_red", new BlockPlantWall(MaterialColor.COLOR_RED));
	public static final Block JUNGLE_MOSS = registerBlock("jungle_moss", new BlockPlantWall(MaterialColor.COLOR_LIGHT_GREEN));
	
	// Decorations //
	public static final Block PIG_STATUE_RESPAWNER = registerBlock("pig_statue_respawner", new BlockStatueRespawner());
	public static final Block CINCINNASITE_POT = registerBlock("cincinnasite_pot", new BlockBNPot(CINCINNASITE_BLOCK));
	public static final Block BRICK_POT = registerBlock("brick_pot", new BlockBNPot(Blocks.NETHER_BRICKS));
	public static final Block POTTED_PLANT = registerBlockNI("potted_plant", new BlockPottedPlant());
	public static final Block GEYSER = registerBlock("geyser", new BlockGeyser());
	public static final Block NETHERRACK_STALACTITE = registerStalactite("netherrack_stalactite", Blocks.NETHERRACK);
	public static final Block GLOWSTONE_STALACTITE = registerStalactite("glowstone_stalactite", Blocks.GLOWSTONE);
	public static final Block BLACKSTONE_STALACTITE = registerStalactite("blackstone_stalactite", Blocks.BLACKSTONE);
	public static final Block BASALT_STALACTITE = registerStalactite("basalt_stalactite", Blocks.BASALT);
	public static final Block BONE_STALACTITE = registerStalactite("bone_stalactite", BONE_BLOCK);
	
	
	// Fire Bowls
	public static final Block CINCINNASITE_FIRE_BOWL = registerFireBowl("cincinnasite_fire_bowl", CINCINNASITE_FORGED, Blocks.NETHERRACK, NetherItems.CINCINNASITE_INGOT);
	public static final Block BRICKS_FIRE_BOWL = registerFireBowl("bricks_fire_bowl", NETHER_BRICK_TILE_LARGE, Blocks.NETHERRACK, Items.NETHER_BRICK);
	public static final Block NETHERITE_FIRE_BOWL = registerFireBowl("netherite_fire_bowl", Blocks.NETHERITE_BLOCK, Blocks.NETHERRACK, Items.NETHERITE_INGOT);
	
	public static final Block CINCINNASITE_FIRE_BOWL_SOUL = registerFireBowl("cincinnasite_fire_bowl_soul", CINCINNASITE_FORGED, Blocks.SOUL_SAND, NetherItems.CINCINNASITE_INGOT);
	public static final Block BRICKS_FIRE_BOWL_SOUL = registerFireBowl("bricks_fire_bowl_soul", NETHER_BRICK_TILE_LARGE, Blocks.SOUL_SAND, Items.NETHER_BRICK);
	public static final Block NETHERITE_FIRE_BOWL_SOUL = registerFireBowl("netherite_fire_bowl_soul", Blocks.NETHERITE_BLOCK, Blocks.SOUL_SAND, Items.NETHERITE_INGOT);
	
	// Terrain //
	public static final Block NETHERRACK_MOSS = registerBlock("netherrack_moss", new BlockTerrain());
	public static final Block NETHER_MYCELIUM = registerBlock("nether_mycelium", new BlockNetherMycelium());
	public static final Block JUNGLE_GRASS = registerBlock("jungle_grass", new BlockTerrain());
	public static final Block MUSHROOM_GRASS = registerBlock("mushroom_grass", new BlockTerrain());
	public static final Block SEPIA_MUSHROOM_GRASS = registerBlock("sepia_mushroom_grass", new BlockTerrain());
	public static final Block VEINED_SAND = registerBlockNI("veined_sand", new BlockVeinedSand());
	public static final Block FARMLAND = registerBlock("farmland", new BlockFarmland());
	public static final Block SWAMPLAND_GRASS = registerBlock("swampland_grass", new BlockTerrain());
	public static final Block CEILING_MUSHROOMS = registerBlock("ceiling_mushrooms", new BlockTerrain());
	
	// Roofs //
	public static final Block ROOF_TILE_NETHER_BRICKS = registerRoof("roof_tile_nether_bricks", Blocks.NETHER_BRICKS);
	public static final Block ROOF_TILE_NETHER_BRICKS_STAIRS = registerStairs("roof_tile_nether_bricks_stairs", ROOF_TILE_NETHER_BRICKS);
	public static final Block ROOF_TILE_NETHER_BRICKS_SLAB = registerSlab("roof_tile_nether_bricks_slab", ROOF_TILE_NETHER_BRICKS);
	public static final Block ROOF_TILE_CINCINNASITE = registerRoof("roof_tile_cincinnasite", CINCINNASITE_FORGED);
	public static final Block ROOF_TILE_CINCINNASITE_STAIRS = registerStairs("roof_tile_cincinnasite_stairs", ROOF_TILE_CINCINNASITE);
	public static final Block ROOF_TILE_CINCINNASITE_SLAB = registerSlab("roof_tile_cincinnasite_slab", ROOF_TILE_CINCINNASITE);
	
	
	// Craft Stations //
	public static final Block BLACKSTONE_FURNACE = registerFurnace("blackstone_furnace", Blocks.BLACKSTONE);
	public static final Block BASALT_FURNACE = registerFurnace("basalt_furnace", Blocks.BASALT);
	public static final Block NETHERRACK_FURNACE = registerFurnace("netherrack_furnace", Blocks.NETHERRACK);
	public static final Block CINCINNASITE_FORGE = registerBlock("cincinnasite_forge", new BlockCincinnasiteForge());
	public static final Block NETHER_BREWING_STAND = registerBlock("nether_brewing_stand", new BNBrewingStand());
	public static final Block CINCINNASITE_ANVIL = registerBlock("cincinnasite_anvil", new BlockCincinnasiteAnvil());
	
	public static final Block CRAFTING_TABLE_CRIMSON = registerCraftingTable("crafting_table_crimson", Blocks.CRIMSON_PLANKS);
	public static final Block CRAFTING_TABLE_WARPED = registerCraftingTable("crafting_table_warped", Blocks.WARPED_PLANKS);
	
	
	// Storage
	public static final Block CHEST_OF_DRAWERS = registerBlock("chest_of_drawers", new BlockChestOfDrawers());
	
	public static final Block CHEST_CRIMSON = registerChest("crimson_chest", Blocks.CRIMSON_PLANKS);
	public static final Block CHEST_WARPED = registerChest("warped_chest", Blocks.WARPED_PLANKS);
	
	public static final Block BARREL_CRIMSON = registerBarrel("crimson_barrel", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB);
	public static final Block BARREL_WARPED = registerBarrel("warped_barrel", Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB);
	
	
	// Taburets //
	public static final Block TABURET_OAK = registerTaburet("oak_taburet", Blocks.OAK_SLAB);
	public static final Block TABURET_SPRUCE = registerTaburet("spruce_taburet", Blocks.SPRUCE_SLAB);
	public static final Block TABURET_BIRCH = registerTaburet("birch_taburet", Blocks.BIRCH_SLAB);
	public static final Block TABURET_JUNGLE = registerTaburet("jungle_taburet", Blocks.JUNGLE_SLAB);
	public static final Block TABURET_ACACIA = registerTaburet("acacia_taburet", Blocks.ACACIA_SLAB);
	public static final Block TABURET_DARK_OAK = registerTaburet("dark_oak_taburet", Blocks.DARK_OAK_SLAB);
	public static final Block TABURET_CRIMSON = registerTaburet("crimson_taburet", Blocks.CRIMSON_SLAB);
	public static final Block TABURET_WARPED = registerTaburet("warped_taburet", Blocks.WARPED_SLAB);
	
	public static final Block TABURET_CINCINNASITE = registerTaburet("taburet_cincinnasite", CINCINNASITE_SLAB);
	
	
	// Chairs
	public static final Block CHAIR_OAK = registerChair("oak_chair", Blocks.OAK_SLAB);
	public static final Block CHAIR_SPRUCE = registerChair("spruce_chair", Blocks.SPRUCE_SLAB);
	public static final Block CHAIR_BIRCH = registerChair("birch_chair", Blocks.BIRCH_SLAB);
	public static final Block CHAIR_JUNGLE = registerChair("jungle_chair", Blocks.JUNGLE_SLAB);
	public static final Block CHAIR_ACACIA = registerChair("acacia_chair", Blocks.ACACIA_SLAB);
	public static final Block CHAIR_DARK_OAK = registerChair("dark_oak_chair", Blocks.DARK_OAK_SLAB);
	public static final Block CHAIR_CRIMSON = registerChair("crimson_chair", Blocks.CRIMSON_SLAB);
	public static final Block CHAIR_WARPED = registerChair("warped_chair", Blocks.WARPED_SLAB);
	
	public static final Block CHAIR_CINCINNASITE = registerChair("chair_cincinnasite", CINCINNASITE_SLAB);
	
	// Stools //
	public static final Block BAR_STOOL_OAK = registerBarStool("oak_bar_stool", Blocks.OAK_SLAB);
	public static final Block BAR_STOOL_SPRUCE = registerBarStool("spruce_bar_stool", Blocks.SPRUCE_SLAB);
	public static final Block BAR_STOOL_BIRCH = registerBarStool("birch_bar_stool", Blocks.BIRCH_SLAB);
	public static final Block BAR_STOOL_JUNGLE = registerBarStool("jungle_bar_stool", Blocks.JUNGLE_SLAB);
	public static final Block BAR_STOOL_ACACIA = registerBarStool("acacia_bar_stool", Blocks.ACACIA_SLAB);
	public static final Block BAR_STOOL_DARK_OAK = registerBarStool("dark_oak_bar_stool", Blocks.DARK_OAK_SLAB);
	public static final Block BAR_STOOL_CRIMSON = registerBarStool("crimson_bar_stool", Blocks.CRIMSON_SLAB);
	public static final Block BAR_STOOL_WARPED = registerBarStool("warped_bar_stool", Blocks.WARPED_SLAB);
	
	public static final Block BAR_STOOL_CINCINNASITE = registerBarStool("bar_stool_cincinnasite", CINCINNASITE_SLAB);
	
	// Ladders //
	public static final Block CRIMSON_LADDER = registerLadder("crimson_ladder", Blocks.CRIMSON_PLANKS);
	public static final Block WARPED_LADDER = registerLadder("warped_ladder", Blocks.WARPED_PLANKS);
	
	
	protected NetherBlocks(CreativeModeTab creativeTab) {
		super(creativeTab, Configs.BLOCKS);
	}
	
	private static ru.bclib.registry.BlockRegistry BLOCKS_REGISTRY;
	
	@NotNull
	public static ru.bclib.registry.BlockRegistry getBlockRegistry() {
		if (BLOCKS_REGISTRY == null) {
			BLOCKS_REGISTRY = new NetherBlocks(CreativeTabs.BN_TAB);
		}
		return BLOCKS_REGISTRY;
	}
	
	public static List<Block> getModBlocks() {
		return BlockRegistry.getModBlocks(BetterNether.MOD_ID);
	}
	
	public static List<Item> getModBlockItems() {
		return BlockRegistry.getModBlockItems(BetterNether.MOD_ID);
	}
	
	public static Block registerBlock(String name, Block block, Tag.Named<Block>... tags) {
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, block);
			if (tags.length>0){
				TagAPI.addTags(block, tags);
			}
		}
		return block;
	}
	
	private static Block registerBlockNI(String name, Block block) {
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			return registerBlock(name, block, false);
		}
		return block;
	}
	
	public static Block registerBlockDirectly(String name, Block block) {
		return registerBlock(name, block, true);
	}
	
	private static Block registerBlock(String name, Block block, boolean hasItem) {
		final BlockRegistry blockRegistry = getBlockRegistry();
		final ResourceLocation location = new ResourceLocation(BetterNether.MOD_ID, name);
		if (hasItem) {
			blockRegistry.register(location, block);
		}
		else {
			blockRegistry.registerBlockOnly(location, block);
		}
		return block;
	}
	
	private static void addFuel(Block source, Block result) {
		if (source.defaultBlockState()
				  .getMaterial()
				  .isFlammable()) {
			FuelRegistry.INSTANCE.add(result, 40);
		}
	}
	
	public static Block registerStairs(String name, Block source, Tag.Named<Block>... tags) {
		Block stairs = new BaseStairsBlock(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, stairs);
			addFuel(source, stairs);
			RecipesHelper.makeStairsRecipe(source, stairs);
			if (tags.length>0){
				TagAPI.addTags(stairs, tags);
			}
		}
		return stairs;
	}
	
	public static Block registerSlab(String name, Block source, Tag.Named<Block>... tags) {
		Block slab = new BaseSlabBlock(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, slab);
			addFuel(source, slab);
			RecipesHelper.makeSlabRecipe(source, slab);
			if (tags.length>0){
				TagAPI.addTags(slab, tags);
			}
		}
		return slab;
	}
	
	private static Block registerRoof(String name, Block source) {
		Block roof = new BlockBase(FabricBlockSettings.copyOf(source));
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, roof);
			addFuel(source, roof);
			RecipesHelper.makeRoofRecipe(source, roof);
		}
		return roof;
	}
	
	public static Block registerButton(String name, Block source) {
		Block button = new BaseWoodenButtonBlock(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, button);
			addFuel(source, button);
			RecipesHelper.makeButtonRecipe(source, button);
		}
		return button;
	}
	
	public static Block registerPlate(String name, Block source) {
		Block plate = new BasePressurePlateBlock(Sensitivity.EVERYTHING, source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, plate);
			addFuel(source, plate);
			RecipesHelper.makePlateRecipe(source, plate);
		}
		return plate;
	}
	
	private static Block registerPlate(String name, Block source, Sensitivity rule) {
		Block plate = new BasePressurePlateBlock(rule, source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, plate);
			addFuel(source, plate);
			RecipesHelper.makePlateRecipe(source, plate);
		}
		return plate;
	}

	public static Block registerSoulBlock(String name, Block block) {
		return registerBlock(name, block, BlockTags.SOUL_FIRE_BASE_BLOCKS, BlockTags.SOUL_SPEED_BLOCKS);
	}
	
	public static Block registerMakeable2X2Soul(String name, Block result, String group, Block... sources) {
		final Block block = registerMakeable2X2(name, result, group, sources);
		TagAPI.addTags(block, BlockTags.SOUL_FIRE_BASE_BLOCKS, BlockTags.SOUL_SPEED_BLOCKS);
		return block;
	}
	
	public static Block registerMakeable2X2(String name, Block result, String group, Block... sources) {
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, result);
			for (Block source : sources) {
				RecipesHelper.makeSimpleRecipe2(source, result, 4, group);
			}
		}
		return result;
	}
	
	public static Block registerWall(String name, Block source) {
		Block wall = new BNWall(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, wall);
			RecipesHelper.makeWallRecipe(source, wall);
		}
		return wall;
	}
	
	public static Block registerCraftingTable(String name, Block source) {
		Block block = new BaseCraftingTableBlock(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, block);
			TagAPI.addTags(block, TagAPI.BLOCK_WORKBENCHES);
			TagAPI.addTags(block, TagAPI.ITEM_WORKBENCHES);
			
			GridRecipe.make(new ResourceLocation(BetterNether.MOD_ID, name), block)
					  .checkConfig(Configs.RECIPES)
					  .setShape("##", "##")
					  .addMaterial('#', source)
					  .setGroup("nether" + "_tables")
					  .build();
			
			FlammableBlockRegistry.getDefaultInstance()
								  .add(block, 5, 20);
		}
		
		return block;
	}
	
	public static Block registerChest(String name, Block planks) {
		Block chest = new BaseChestBlock(planks);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, chest);
			TagAPI.addTags(chest, TagAPI.BLOCK_CHEST);
			TagAPI.addTags(chest, TagAPI.ITEM_CHEST);
			addFuel(planks, chest);
			//RecipesHelper.makeRoundRecipe(planks, chest, "nether_chest");
			GridRecipe.make(new ResourceLocation(BetterNether.MOD_ID, name), chest)
					  .checkConfig(Configs.RECIPES)
					  .setShape("###", "# #", "###")
					  .addMaterial('#', planks)
					  .setGroup("nether" + "_chests")
					  .build();
			
			FlammableBlockRegistry.getDefaultInstance()
								  .add(chest, 5, 20);
		}
		
		return chest;
	}
	
	public static Block registerBarrel(String name, Block source, Block slab) {
		Block block = new BaseBarrelBlock(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, block);
			addFuel(source, block);
			//RecipesHelper.makeBarrelRecipe(source, slab, block);
			GridRecipe.make(new ResourceLocation(BetterNether.MOD_ID, name), block)
					  .checkConfig(Configs.RECIPES)
					  .setShape("#S#", "# #", "#S#")
					  .addMaterial('#', source)
					  .addMaterial('S', slab)
					  .setGroup("nether" + "_barrels")
					  .build();
			
			FlammableBlockRegistry.getDefaultInstance()
								  .add(block, 5, 20);
		}
		
		return block;
	}
	
	public static Block registerLadder(String name, Block source) {
		Block block = new BaseLadderBlock(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, block);
			TagAPI.addTags(block, BlockTags.CLIMBABLE);
			
			addFuel(source, block);
			//RecipesHelper.makeLadderRecipe(source, block);
			
			GridRecipe.make(new ResourceLocation(BetterNether.MOD_ID, name), block)
					  .checkConfig(Configs.RECIPES)
					  .setOutputCount(3)
					  .setShape("I I", "I#I", "I I")
					  .addMaterial('#', source)
					  .addMaterial('I', Items.STICK)
					  .setGroup("nether" + "_ladders")
					  .build();
			FlammableBlockRegistry.getDefaultInstance()
								  .add(block, 5, 20);
		}
		
		return block;
	}
	
	public static Block registerTaburet(String name, Block source) {
		Block block = new BNTaburet(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, block);
			addFuel(source, block);
			NetherWoodenMaterial.makeTaburetRecipe(Configs.RECIPES, new ResourceLocation(BetterNether.MOD_ID, name), block, source);
		}
		
		return block;
	}
	
	public static Block registerChair(String name, Block source) {
		Block block = new BNNormalChair(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, block);
			addFuel(source, block);
			NetherWoodenMaterial.makeChairRecipe(Configs.RECIPES, new ResourceLocation(BetterNether.MOD_ID, name), block, source);
		}
		
		return block;
	}
	
	public static Block registerBarStool(String name, Block source) {
		Block block = new BNBarStool(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, block);
			addFuel(source, block);
			NetherWoodenMaterial.makeBarStoolRecipe(Configs.RECIPES, new ResourceLocation(BetterNether.MOD_ID, name), block, source);
		}
		
		return block;
	}
	
	public static Block registerFurnace(String name, Block source) {
		Block block = new BlockNetherFurnace(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, block);
			RecipesHelper.makeRoundRecipe(source, block, "nether_furnace");
		}
		
		return block;
	}
	
	private static Block registerStalactite(String name, Block source) {
		Block block = new BlockStalactite(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, block);
			RecipesHelper.makeSimpleRecipe2(block, source, 1, "nether_stalactite");
		}
		
		return block;
	}
	
	private static Block registerFireBowl(String name, Block source, Block inside, Item leg) {
		Block block = new BlockFireBowl(source);
		if (Configs.BLOCKS.getBoolean("blocks", name, true)) {
			registerBlockDirectly(name, block);
			if (!name.startsWith("netherite")) {
				RecipesHelper.makeFireBowlRecipe(source, inside, leg, block);
			}
		}
		
		return block;
	}
}
