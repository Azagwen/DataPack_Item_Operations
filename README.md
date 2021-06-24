# Datapack Item Operations

A mod that allows data-driven Item Operations via Datapack.

The mod adds a "dp_item_ops" folder to the vanilla data folder which allows for the addition of more data types, such as Item operations.

## Installation 

Download the mod and put it in your game's "mods" folder, you can now use the mod's datapack features.

## Developpers
To use this mod in your own mods, you need to add the following to your `build.gradle`

```java
repositories {
	maven {
		name "Modrinth"
		url "https://api.modrinth.com/maven"
	}
}
```
```java
dependencies {
        modImplementation "maven.modrinth:dp_item_ops:X.X.X"
        
        //If you want it included in your mod
        include "maven.modrinth:dp_item_ops:X.X.X"
}
```
Replacing `X.X.X` with the latest version.

## License

This mod is available under the MIT license.
