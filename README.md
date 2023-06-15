# %player:dimension% Placeholder

Adds placeholders that return the (mod that adds the) dimension a player is in.  
To be used with mods that implement [Placeholders API](https://placeholders.pb4.eu).

Placeholders:
- `%player:dimension%` - returns the dimension a player is in
- `%player:dimension_mod%` - returns the name of the "mod" that adds the dimension a player is in
- `%player:dimension_raw%` - returns dimension path
- `%player:dimension_mod_raw%` - returns dimension namespace

Examples:

Minecraft's "The Nether":
- `dimension` = `The Nether`
- `dimension_mod` = `Minecraft`
- `dimension_raw` = `the_nether`
- `dimension_mod_raw` = `minecraft`

Ad Astra's "Moon"
- `dimension` = `Moon`
- `dimension_mod` = `Ad Astra`
- `dimension_raw` = `moon`
- `dimension_mod_raw` = `ad_astra`

etc.

Planned features:
- Configurable colors for dimensions (green for overworld, red for the_nether, purple for the_end, ...)
