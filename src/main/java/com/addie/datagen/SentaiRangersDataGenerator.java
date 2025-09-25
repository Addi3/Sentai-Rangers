package com.addie.datagen;

import com.addie.datagen.providers.*;
import dev.amble.lib.datagen.lang.AmbleLanguageProvider;
import dev.amble.lib.datagen.lang.LanguageType;
import dev.amble.lib.datagen.loot.AmbleBlockLootTable;
import dev.amble.lib.datagen.sound.AmbleSoundProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SentaiRangersDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();

        generateSoundData(pack);
        genModels(pack);
        genLang(pack);
        generateRecipes(pack);
        generateAchievement(pack);
        genTags(pack);
  //      genLoot(pack);
	}

    private void generateAchievement(FabricDataGenerator.Pack pack) {
        pack.addProvider(SentaiRangersAchivementProvider::new);
    }

    private void genTags(FabricDataGenerator.Pack pack) {
        pack.addProvider(SentaiRangersBlockTagProvider::new);
        pack.addProvider(SentaiRangersItemTagProvider::new);
    }

//    private void genLoot(FabricDataGenerator.Pack pack) {
//        pack.addProvider((((output, registriesFuture) -> new AmbleBlockLootTable(output).withBlocks(RegenerationModBlocks.class))));
//    }

    public void generateSoundData(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> new AmbleSoundProvider(output))));
    }

    private void genModels(FabricDataGenerator.Pack pack) {
        pack.addProvider(((output, registriesFuture) -> {
            SentaiRangersModelGen provider = new SentaiRangersModelGen(output);

            return provider;
        }));
    }

    private void genLang(FabricDataGenerator.Pack pack) {
        genEnglish(pack);
    }

    private void genEnglish(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registry) -> {
            AmbleLanguageProvider provider = new AmbleLanguageProvider(output, LanguageType.EN_US);



            return provider;
        })));
    }

    public void generateRecipes(FabricDataGenerator.Pack pack) {
        pack.addProvider((((output, registriesFuture) -> {
            SentaiRangersRecipeProvider provider = new SentaiRangersRecipeProvider(output);
            return provider;

        })));
    }

}
