# AzuriomSkinAPIBungeecord
**Plugin minecraft permettant d'auto-update son skin via l'api SkinAPI de Azuriom**

**Une update du plugin AzuriomSkinAPI mais configuré pour les serveurs fonctionnant sous Bungeecord, Waterfall ou autres version utilisant l'API Bungeecord**

**Edit : Le plugin ne fonctionne PAS sur vélocity**

# Le plugin utilise le sous plugin SkinRestorer afin d'appliquer un skin venant de l'api SkinApi de votre site a un utilisateur quand il se connecte ou, si il le change sur le site en étant connecté, pouvoir l'update via une commande.

**Si vous souhaitez utiliser la version Spigot de AzuriomSkinAPI : https://www.spigotmc.org/resources/azuriomskinapi.112676/**

**Commandes, Description et permission :**

| Commande | Description | Permission |
|----------|----------|----------|
| /skin-update  | Permet d'update son propre skin en étant connecté.  | azuriomskinapi.skin-update | 
| /forceupdate-skin | Permet de forcer l'update d'un skin sur un utilisateur connecté. | azuriomskinapi.forceupdate-skin |


## Vous pouvez changer l'intégralité des messages du plugin via le fichier de configuration.

**Présentation du fichier de configuration :**

![Configuration de base](https://cdn.discordapp.com/attachments/1109918463415291944/1153087248418488430/image.png)

Présentation dans les grands traits : 

1. skin_api_url : Mettre le premier lien présenté dans la configuration du plugin Azuriom ( plugin SkinAPI ), en changeant {playerid} par {player}

**Tout les autres messages sont des messages affichés selon le contexte des commandes.**

**Le skin s'updatera a chaque fois que le joueur se connectera sur le Bungeecord, ou dés qu'une personne avec une permission nécessaire sur le bungeecord executera une commande pour auto update.**

**Pour mettre une permission sur Bungeecord : https://www.youtube.com/watch?v=5vt2km_ggn0 ( la vidéo est en anglais )**
