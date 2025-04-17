from beet import JsonFile
import os

# Run this in the main project directory to generate files in ./src!
# To add new mods/planks, just use the dictionary below:
# the key is the mod name, and the value is a list of plank names.

compat_generated = {
    "betterend": [
        "dragon_tree",
        "end_lotus",
        "helix_tree",
        "jellyshroom",
        "lacugrove",
        "lucernia",
        "mossy_glowshroom",
        "pythadendron",
        "tenanea",
        "umbrella_tree"
    ],
    "betternether": [
        "anchor_tree",
        "mushroom_fir",
        "nether_mushroom",
        "nether_reed",
        "nether_sakura",
        "rubeus",
        "stalagnate",
        "wart",
        "willow"
    ],
    "biomesoplenty": [
        "dead",
        "empyreal",
        "fir",
        "hellbark",
        "jacaranda",
        "magic",
        "mahogany",
        "maple",
        "palm",
        "pine",
        "redwood",
        "umbran",
        "willow"
    ],
    "cinderscapes": [
        "scorched",
        "umbral"
    ],
    "terrestria": [
        "cypress",
        "hemlock",
        "japanese_maple",
        "rainbow_eucalyptus",
        "redwood",
        "rubber",
        "sakura",
        "willow",
        "yucca_palm"
    ],
    "traverse": [
        "fir"
    ],
    "wilderwild": [
        "baobab",
        "cypress",
        "palm"
    ],
    "pyrite": [
        "white_stained",
        "light_gray_stained",
        "gray_stained",
        "black_stained",
        "brown_stained",
        "red_stained",
        "orange_stained",
        "honey_stained",
        "yellow_stained",
        "poisonous_stained",
        "lime_stained",
        "green_stained",
        "glow_stained",
        "cyan_stained",
        "nostalgia_stained",
        "star_stained",
        "light_blue_stained",
        "blue_stained",
        "purple_stained",
        "dragon_stained",
        "magenta_stained",
        "rose_stained",
        "pink_stained",
        "red_mushroom",
        "brown_mushroom",
        "azalea",
    ],
}

# some mods return empty block settings, so we force them to use oak plank data instead:
naughty_mod_corner = [
    "terrestria",
    "traverse",
    "wilderwild"
]

def save(file: JsonFile, path):
    if not os.path.exists(os.path.dirname(path)):
        os.makedirs(os.path.dirname(path))
    file.dump(origin="./", path=path)


def add_treated_plank(m, n):
    p = f"{n}_planks"
    t = f"treated_{p}"

    # recipe
    file = {
        "type": "minecraft:crafting_shaped",
        "category": "building",
        "group": "rounded:treated_planks",
        "key": {
            "#": {
                "item": f"{m}:{p}"
            },
            "X": {
                "item": "minecraft:honeycomb"
            }
        },
        "pattern": [
            "###",
            "#X#",
            "###"
        ],
        "result": {
            "count": 8,
            "id": f"rounded:compat/{m}/{t}"
        },
        "fabric:load_conditions": [
            {
                "condition": "fabric:all_mods_loaded",
                "values": [
                    f"{m}"
                ]
            }
        ]
    }
    save(JsonFile(file), f"src/main/resources/data/rounded/recipe/compat/{m}/{t}.json")

    # recipe advancement
    file = {
        "parent": "minecraft:recipes/root",
        "criteria": {
            "has_log": {
                "conditions": {
                    "items": [
                        {
                            "items": "minecraft:honeycomb"
                        }
                    ]
                },
                "trigger": "minecraft:inventory_changed"
            },
            "has_the_recipe": {
                "conditions": {
                    "recipe": f"rounded:compat/{m}/{t}"
                },
                "trigger": "minecraft:recipe_unlocked"
            }
        },
        "requirements": [
            [
                "has_the_recipe",
                "has_log"
            ]
        ],
        "rewards": {
            "recipes": [
                f"rounded:compat/{m}/{t}"
            ]
        },
        "fabric:load_conditions": [
            {
                "condition": "fabric:all_mods_loaded",
                "values": [
                    f"{m}"
                ]
            }
        ]
    }
    save(JsonFile(file), f"src/main/resources/data/rounded/advancement/recipes/building_blocks/compat/{m}/{t}.json")

    # loot table
    file = {
        "type": "minecraft:block",
        "pools": [
            {
                "bonus_rolls": 0.0,
                "conditions": [
                    {
                        "condition": "minecraft:survives_explosion"
                    }
                ],
                "entries": [
                    {
                        "type": "minecraft:item",
                        "name": f"rounded:compat/{m}/{t}"
                    }
                ],
                "rolls": 1.0
            }
        ],
        "random_sequence": f"rounded:blocks/compat/{m}/{t}",
        "fabric:load_conditions": [
            {
                "condition": "fabric:all_mods_loaded",
                "values": [
                    f"{m}"
                ]
            }
        ]
    }
    save(JsonFile(file), f"src/main/resources/data/rounded/loot_table/blocks/compat/{m}/{t}.json")

    # tags
    tag = {
        "required": False,
        "id": f"rounded:compat/{m}/{t}"
    }

    file = JsonFile(source_path="src/main/resources/data/rounded/tags/item/treated_planks.json").data
    if tag not in file["values"]:
        file["values"].append(tag)
        JsonFile(file).dump(origin="./", path="src/main/resources/data/rounded/tags/item/treated_planks.json")

    file = JsonFile(source_path="src/main/resources/data/minecraft/tags/block/mineable/axe.json").data
    if tag not in file["values"]:
        file["values"].append(tag)
        JsonFile(file).dump(origin="./", path="src/main/resources/data/minecraft/tags/block/mineable/axe.json")

    # blockstate
    file = {
        "variants": {
            "": {
                "model": f"rounded:block/compat/{m}/{t}"
            }
        }
    }
    save(JsonFile(file), f"src/client/resources/assets/rounded/blockstates/compat/{m}/{t}.json")

    # block model
    file = {
        "parent": "minecraft:block/cube_all",
        "textures": {
            "all": f"rounded:block/compat/{m}/{t}"
        }
    }
    save(JsonFile(file), f"src/client/resources/assets/rounded/models/block/compat/{m}/{t}.json")

    # item model
    file = {
        "parent": f"rounded:block/compat/{m}/{t}"
    }
    save(JsonFile(file), f"src/client/resources/assets/rounded/models/item/compat/{m}/{t}.json")

    # language key
    # TODO: add automatic ripping for other languages, if they are present
    # both in rounded and in the source mod
    file = JsonFile(source_path="src/client/resources/assets/rounded/lang/en_us.json").data
    file[f"block.rounded.compat.{m}.{t}"] = f"{t.replace("_", " ").title()}"
    JsonFile(file).dump(origin="./", path="src/client/resources/assets/rounded/lang/en_us.json")


def add_treated_plank_code(m, l):
    module_name = m.replace("_", " ").title().replace(" ", "") + "Compat"
    file = """package com.lumiscosity.rounded.compat;

            import net.minecraft.block.AbstractBlock;
            import net.minecraft.block.Block;
            import net.minecraft.item.BlockItem;
            import net.minecraft.item.Item;
            import net.minecraft.registry.Registries;
            import net.minecraft.util.Identifier;

            import static com.lumiscosity.rounded.blocks.RegisterBlocks.register_treated_plank;

            public class {} {{""".format(module_name)

    for i in l:
        p = f"{i}_planks"
        t = f"treated_{p}"

        if m in naughty_mod_corner:
            file += f"""
                public static final Block {t.upper()} = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("minecraft", "oak_planks")))
                );
                public static final Item {t.upper()}_ITEM = new BlockItem({t.upper()}, new Item.Settings());
            
            """
        else:
            file += f"""
                public static final Block {t.upper()} = new Block(
                    Block.Settings.copy(Registries.BLOCK.get(Identifier.of("{m}", "{p}")))
                );
                public static final Item {t.upper()}_ITEM = new BlockItem({t.upper()}, new Item.Settings());
            
            """

    file += "   public static void register() {"

    for i in l:
        t = f"treated_{i}_planks"

        file += f'        register_treated_plank("compat/{m}/{t}", {t.upper()}, {t.upper()}_ITEM, "{m}", "{i}");\n'

    file += """
        }
    }"""

    module = open(f"src/main/java/com/lumiscosity/rounded/compat/{module_name}.java", "w")
    module.write(file)
    module.close()

for i in compat_generated.keys():
    add_treated_plank_code(i, compat_generated[i])
    for j in compat_generated[i]:
        add_treated_plank(i, j)