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
        "wart_planks",
        "willow_planks"
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
        "yucca"
    ],
    "traverse": [
        "fir"
    ],
    "wilderwild": [
        "baobab",
        "cypress",
        "palm"
    ],
}


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
    save(JsonFile(file), f"src/main/resources/data/rounded/recipe/compat/{m}/{t}")

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
    save(JsonFile(file), f"src/main/resources/data/rounded/advancement/recipes/building_blocks/compat/{m}/{t}")

    # item tag
    file = JsonFile(source_path="src/main/resources/data/rounded/tags/item/treated_planks.json").data
    print(file)
    file["values"].append(
        {
            "required": False,
            "id": f"rounded:compat/{m}/{t}"
        }
    )
    JsonFile(file).dump(origin="./", path="src/main/resources/data/rounded/tags/item/treated_planks.json")

    # blockstate
    file = {
        "variants": {
            "": {
                "model": f"rounded:block/compat/{m}/{t}"
            }
        }
    }
    save(JsonFile(file), f"src/client/resources/assets/rounded/blockstates/compat/{m}/{t}")

    # block model
    file = {
        "parent": "minecraft:block/cube_all",
        "textures": {
            "all": f"rounded:block/compat/{m}/{t}"
        }
    }
    save(JsonFile(file), f"src/client/resources/assets/rounded/models/block/compat/{m}/{t}")

    # item model
    file = {
        "parent": f"rounded:block/compat/{m}/{t}"
    }
    save(JsonFile(file), f"src/client/resources/assets/rounded/models/item/compat/{m}/{t}")

    # language key
    # TODO: add automatic ripping for other languages, if they are present
    # both in rounded and in the source mod
    file = JsonFile(source_path="src/client/resources/assets/rounded/lang/en_us.json").data
    file[f"block.rounded.compat.{m}.{t}"] = f"{t.replace("_", " ").title()}"
    JsonFile(file).dump(origin="./", path="src/client/resources/assets/rounded/lang/en_us.json")


for i in compat_generated.keys():
    for j in compat_generated[i]:
        add_treated_plank(i, j)
