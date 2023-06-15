package cc.unilock.playerdimensionplaceholder;

import eu.pb4.placeholders.api.PlaceholderResult;
import eu.pb4.placeholders.api.Placeholders;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class PlayerDimensionPlaceholder implements DedicatedServerModInitializer {
	//public static final Logger LOGGER = LoggerFactory.getLogger("PlayerDimensionPlaceholder");

	@Override
	public void onInitializeServer() {
		ServerLifecycleEvents.SERVER_STARTED.register((server) -> registerPlaceholders());
	}

	// getDimensionKey (...returns Identifier)
	// .getValue       = minecraft:the_nether
	//   .getNamespace = minecraft
	//   .getPath      = the_nether

	private void registerPlaceholders() {
		Placeholders.register(new Identifier("player", "dimension"), (ctx, arg) -> {
			if (ctx.hasPlayer()) {
				return PlaceholderResult.value(format(ctx.player().getServerWorld().getDimensionKey().getValue().getPath()));
			} else {
				return PlaceholderResult.invalid("No player!");
			}
		});
		Placeholders.register(new Identifier("player", "dimension_mod"), (ctx, arg) -> {
			if (ctx.hasPlayer()) {
				return PlaceholderResult.value(format(ctx.player().getServerWorld().getDimensionKey().getValue().getNamespace()));
			} else {
				return PlaceholderResult.invalid("No player!");
			}
		});

		Placeholders.register(new Identifier("player", "dimension_raw"), (ctx, arg) -> {
			if (ctx.hasPlayer()) {
				return PlaceholderResult.value(ctx.player().getServerWorld().getDimensionKey().getValue().getPath());
			} else {
				return PlaceholderResult.invalid("No player!");
			}
		});
		Placeholders.register(new Identifier("player", "dimension_mod_raw"), (ctx, arg) -> {
			if (ctx.hasPlayer()) {
				return PlaceholderResult.value(ctx.player().getServerWorld().getDimensionKey().getValue().getNamespace());
			} else {
				return PlaceholderResult.invalid("No player!");
			}
		});
	}

	private static Text format(String str) {
		Text text = Text.of(makeTitleCase(str));

		// TODO: apply (configurable) color to returned Text
		//       i.e. green overworld, red the_nether, purple the_end, ...

		return text;
	}

	/**
	 * Converts an underscore-delimited string to title case, with underscores replaced by spaces
	 *
	 * @param str Underscore-delimited string to convert
	 * @return String in title case
	 */
	private static String makeTitleCase(String str) {
		String[] split = str.split("_");
		StringBuilder builder = new StringBuilder();
		int i = 0;

		for(var s : split) {
			split[i] = Character.toUpperCase(s.charAt(0)) + s.substring(1);
			builder.append(split[i]);

			if(i != split.length - 1) {
				builder.append(' ');
			}

			i++;
		}

		str = builder.toString();

		return str;
	}
}
