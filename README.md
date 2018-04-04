# KalStuff
[![codebeat badge](https://codebeat.co/badges/21b4d968-a2f1-427d-b2dd-5654f506281a)](https://codebeat.co/projects/github-com-teammodding-kalstuff) [![Build Status](https://travis-ci.org/TEAMModding/KalStuff.svg?branch=master)](https://travis-ci.org/TEAMModding/KalStuff)

 Source code for a mod that adds various, mostly unrelated things to Minecraft.

 - [Installation](#installation)
 - [Usage](#usage)
 - [Contributing](#contributing)
 - [Credits](#credits)
 - [License](#license)
 
 ## Installation
 ### Prerequisites:
 The easiest way to install KalStuff is by downloading the pre-compiled jars made available on [KalStuff's CurseForge page](https://minecraft.curseforge.com/projects/kalstuff/files). You will also need [Minecraft Forge](https://github.com/MinecraftForge/MinecraftForge) installed, and obviously [Minecraft](https://minecraft.net) itself (unless you are setting up a server). You can also compile KalStuff yourself by following the instructions under [Contributing](#contributing).
 
 Assuming you have everything installed correctly, simply drop the KalStuff jar into your installation's `mods` folder and start the server/client.
 
 ## Usage
 Detailed information on the mod's features can be found on the [KalStuff wiki](https://github.com/TEAMModding/KalStuff/wiki).
 
 ## Contributing
 There are multiple ways in which you can contribute. If you'd like to work on the mod itself, check out [#development](#development) below. You can also help flesh out our [wiki](https://github.com/TEAMModding/KalStuff/wiki/Helping-Fill-The-Wiki). One of the most helpful things you can do is simply to play with the mod and report any bugs you find on the [issue tracker](https://github.com/TEAMModding/KalStuff/issues).
 
 ### Development
 If you'd like to help develop KalStuff - first off, great! - second, you can get started by cloning the repository. After this, you will need to run a command based on your OS and IDE. Check the [ForgeGradle guide](http://www.minecraftforge.net/forum/topic/13860-tutorial-getting-started-with-forgegradle/#initial_setup) for instructions on this (scroll down slightly to the Initial Setup section). After you've set up your workspace and imported it into your IDE, you're almost ready to start working. The master branch is protected, so you will need to create a branch off of it in order to push changes. It is suggested that you create your own branch, preferably titled with your username. Once you have finished everything and are ready to merge your changes with master, submit a pull request with a detailed and accurate description of your changes. Assuming the code passes our [Travis CI build tests](https://travis-ci.org/TEAMModding/KalStuff), the code will be merged into the master branch as soon as someone checks over and verifies your code as good.
 
 #### Compiling
 Building KalStuff is very easy. Go to the root directory of your local repository and once again follow the steps on the [ForgeGradle guide](http://www.minecraftforge.net/forum/topic/13860-tutorial-getting-started-with-forgegradle/#compiling_obfuscating_and_version_details) (again, scroll down, this time until you find the Compiling/Obfuscating and Version Details section). The resulting .jar file should then be placeable in the Forge mods folder to be loaded as normal.
 
 ### Translations
 As of right now we do not have a good system set up for translating the mod for other languages. If you have experience in this field and would like to help get KalStuff ready for translation, please create an issue proposing your plan.
 
 ## Credits
 KalStuff has been made possible by a number of people. These members include, but are not limited to, the following:
 [@TEAMModding](https://github.com/TEAMModding), which consists of:
 - [@Kalman98](https://github.com/orgs/TEAMModding/people/Kalman98) : lead developer
 - [@pianoman373](https://github.com/orgs/TEAMModding/people/pianoman373) : large amounts of code
 - [@PieCoder314](https://github.com/orgs/TEAMModding/people/PieCoder314) : some code and translations
 - [@ParkerMc](https://github.com/orgs/TEAMModding/people/ParkerMc) : code and general git handling
 - [@CircuitLord](https://github.com/orgs/TEAMModding/people/CircuitLord) : code and bugtesting
 - [@AngelGal246](https://github.com/orgs/TEAMModding/people/AngelGal246) : some art assets, including the KalStuff logo(s)
 
 Other people who have assisted in the creation of this mod include the ever-helpful members of the [Minecraft Mod Development Discord server](https://discord.gg/DQfQ8ge). Also the authors of dozens of online tutorials on Java and Minecraft modding, as well as multiple open source mod developers for their code examples.
 
 ## License
 KalStuff is distributed under the GNU General Public License v3.0, which can be found [here](https://github.com/TEAMModding/KalStuff/blob/master/LICENSE).
 
 The original repository for KalStuff can be found at https://github.com/TEAMModding/KalStuff .
