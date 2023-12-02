package group2;

public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(group2.Characters.MainCharacter character) {

        // need more testing to adjust the mainCharacter collision object
        int characterLeftWorldX = character.positionX + character.collisionArea.x;
        int characterRightWorldX = character.positionX + character.collisionArea.width + character.collisionArea.x;
        int characterTopWorldY = character.positionY + character.collisionArea.y;
        int characterBottomWorldY = character.positionY + character.collisionArea.height + character.collisionArea.y;

        int characterLeftCol = characterLeftWorldX / gp.TILE_SIZE;
        int characterRightCol = characterRightWorldX / gp.TILE_SIZE;
        int characterTopRow = characterTopWorldY / gp.TILE_SIZE;
        int characterBottomRow = characterBottomWorldY / gp.TILE_SIZE;

        // we only need to check 2 tiles left + right / top + down
        int tileNum1, tileNum2;

        switch ("up") {
            case "up":
                characterTopRow = (characterTopWorldY - character.speed) / gp.TILE_SIZE;

                // check left top
                tileNum1 = gp.tileM.mapTileNum[characterLeftCol][characterTopRow];

                // check right top
                tileNum2 = gp.tileM.mapTileNum[characterRightCol][characterTopRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    character.collisionOn = true;
                }
                break;
            case "down":
                characterBottomRow = (characterBottomWorldY + character.speed) / gp.TILE_SIZE;
                tileNum1 = gp.tileM.mapTileNum[characterLeftCol][characterBottomRow];
                tileNum2 = gp.tileM.mapTileNum[characterRightCol][characterBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    character.collisionOn = true;
                }
                break;
            case "left":
                characterLeftCol = (characterTopWorldY + character.speed) / gp.TILE_SIZE;
                tileNum1 = gp.tileM.mapTileNum[characterRightCol][characterTopRow];
                tileNum2 = gp.tileM.mapTileNum[characterRightCol][characterBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    character.collisionOn = true;
                }
                break;
            case "right":
                characterRightCol = (characterRightWorldX - character.speed) / gp.TILE_SIZE;
                tileNum1 = gp.tileM.mapTileNum[characterLeftCol][characterTopRow];
                tileNum2 = gp.tileM.mapTileNum[characterLeftCol][characterBottomRow];
                if (gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
                    character.collisionOn = true;
                }
                break;
        }
    }

}
