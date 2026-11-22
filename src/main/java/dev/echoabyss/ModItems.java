package dev.echoabyss;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public final class ModItems {
	// Placeholder for the quest item from the colossus. Get it with: /give @s echo_abyss:tuning_fork
	public static final Item TUNING_FORK = register("tuning_fork", Item::new, new Item.Properties().stacksTo(1));

	private ModItems() {
	}

	private static <T extends Item> T register(String name, Function<Item.Properties, T> factory, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, EchoAbyss.id(name));
		T item = factory.apply(properties.setId(key));
		Registry.register(BuiltInRegistries.ITEM, key, item);
		return item;
	}

	public static void initialize() {
		// Calling this loads the class, which registers the items above.
	}
}
