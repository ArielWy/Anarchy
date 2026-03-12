# Anarchy

A lightweight Paper/Spigot plugin that transforms the overworld into a flat glass world where every broken block drops a random item. The plugin is designed for chaotic survival-style gameplay and experimental anarchy servers.

Instead of mining traditional resources, players obtain items by breaking glass blocks scattered across the world. The result is a fast-paced environment where progression is unpredictable and every block mined could change the game.

---

## Preview


![Gameplay Preview](https://github.com/user-attachments/assets/1cb8a551-bd4c-42dd-a217-3c65e611a606)


---

## Features

### Flat Glass World Generation

The plugin replaces the normal overworld terrain with a completely flat world made entirely of glass blocks.

* Custom world generator
* Simple and predictable terrain
* Ideal for chaotic or experimental game modes


<img src="https://github.com/user-attachments/assets/dd4bf383-5518-44df-9c85-574bf8ad2677"
     alt="Glass World"
     width="400">


---

### Random Item Drops

Whenever a player breaks a glass block, the block drops a **random item** instead of the glass itself.

Characteristics:

* Every block break becomes a loot event
* Items are selected from a predefined list
* Designed to create unpredictable progression


---

### Hidden Player List (TAB)

The plugin disables player names from appearing in the **TAB player list**.

This removes a common information source in multiplayer servers and contributes to the chaotic/anarchy experience.

Effects:

* Players cannot easily see who is online
* Encourages exploration and uncertainty
* Reduces coordination advantages


---

## Installation

1. Download the plugin `.jar`
2. Place it inside your server's `plugins/` directory
3. Restart the server

The plugin will automatically apply its world generation when creating a new world.

---

## Requirements

* Minecraft server running **Paper or Spigot**
* Compatible with modern Minecraft versions (adjust depending on your build)

---

## Configuration

Currently the plugin runs with minimal configuration.

Future updates may introduce configurable options such as:

* Item drop tables
* Drop probabilities
* World generation settings
* Gameplay modifiers

---

## Project Structure (Technical Overview)

Core systems implemented in the plugin:

* **Custom Chunk Generator**
  Generates a flat glass world instead of standard terrain.

* **Block Break Event Handler**
  Intercepts glass block breaking events and replaces drops with randomly selected items.

* **Tab List Manipulation**
  Modifies player list visibility when players connect.

---

## Example Gameplay Flow

1. A player joins the server.
2. The world consists entirely of glass.
3. The player breaks a glass block.
4. Instead of dropping glass, the block produces a random item.
5. The player uses those items to survive, fight, or explore.

The gameplay loop is intentionally simple and unpredictable.

---

## Roadmap

Potential future improvements:

* Configurable drop tables
* Weighted random item system
* Rare loot items
* Custom events triggered by block breaking
* Multiple world generation styles
* Optional scoreboard or progression mechanics

---

## Contributing

Contributions, suggestions, and improvements are welcome.

If you want to propose changes:

1. Fork the repository
2. Create a feature branch
3. Submit a pull request

---

## License



---

## Author

Developed by **Ariel** (olios)
