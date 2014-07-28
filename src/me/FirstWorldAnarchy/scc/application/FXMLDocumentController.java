package me.FirstWorldAnarchy.scc.application;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import me.FirstWorldAnarchy.scc.application.anim.FlipTransition;
import me.FirstWorldAnarchy.scc.application.anim.RollInTransition;
import me.FirstWorldAnarchy.scc.application.anim.RollOutTransition;

/**
 *
 * @author family
 */
public class FXMLDocumentController implements Initializable {

    // General
    @FXML
    private ChoiceBox<String> entitySelect;
    private final String[] entityOptions = {"None", "Arrow", "Bat", "Blaze", "Boat",
        "CaveSpider", "Chicken", "Cow", "Creeper", "EnderCrystal",
        "EnderDragon", "Enderman", "Endermite", "EntityHorse",
        "EyeOfEnderSignal", "FallingSand", "Fireball",
        "FireworksRocketEntity", "Ghast", "Giant", "Guardian", "Item", "ItemFrame",
        "LavaSlime", "LeashKnot", "Lightning", "MinecartChest", "MinecartCommandBlock",
        "MinecartFurnace", "MinecartHopper", "MinecartRideable",
        "MinecartSpawner", "MinecartTNT", "Mob", "Monster", "MushroomCow",
        "Ozelot", "Painting", "Pig", "PigZombie", "PrimedTnt", "Rabbit", "Sheep",
        "Silverfish", "Skeleton", "Slime", "SmallFireball", "Snowball",
        "SnowMan", "Spider", "Squid", "ThrownEnderpearl",
        "ThrownExpBottle", "ThrownPotion", "Villager", "VillagerGolem",
        "Witch", "WitherBoss", "WitherSkull", "Wolf", "XPOrb", "Zombie"};
    @FXML
    private ImageView creeperImage;
    @FXML
    private ImageView zombieImage;
    @FXML
    private TextField xPos;
    @FXML
    private TextField yPos;
    @FXML
    private TextField zPos;
    // End general
    // Attributes
    @FXML
    private CheckBox attributesCheck;
    @FXML
    private CheckBox attributeMove;
    @FXML
    private CheckBox attributeKnock;
    @FXML
    private CheckBox attributeRange;
    @FXML
    private CheckBox attributeHealth;
    @FXML
    private CheckBox attributeDmg;
    @FXML
    private TextField attributeMoveText;
    @FXML
    private TextField attributeKnockText;
    @FXML
    private TextField attributeRangeText;
    @FXML
    private TextField attributeHealthText;
    @FXML
    private TextField attributeDmgText;
    // End Attributes
    // Potion Controls
    @FXML
    private ChoiceBox<Integer> potionId;
    @FXML
    private ListView<String> potionCurrent;
    @FXML
    private ListView<String> potionReference;
    private final String[] potionIds = {"Speed", "Slowness", "Haste",
        "Mining Fatigue", "Strength", "Instant Health", "Instant Damage",
        "Jump Boost", "Nausea", "Regen", "Resistance", "Fire Resistance",
        "Water Breathing", "Invisibility", "Blindness", "Night Vision",
        "Hunger", "Weakness", "Poison", "Wither", "Health Boost",
        "Absorption", "Saturation"};
    @FXML
    private TextField potionDurationText;
    @FXML
    private TextField potionAmpText;
    @FXML
    private CheckBox potionAmbient;
    private final List<PotionEffect> currentPotionsList = new LinkedList<>();
    // End Potion Controls
    // Equipment
    @FXML
    private CheckBox equipmentCheck;
    @FXML
    private TextField handText;
    @FXML
    private TextField feetText;
    @FXML
    private TextField legsText;
    @FXML
    private TextField bodyText;
    @FXML
    private TextField headText;
    @FXML
    private CheckBox dropChanceCheck;
    @FXML
    private TextField handDrop;
    @FXML
    private TextField feetDrop;
    @FXML
    private TextField legsDrop;
    @FXML
    private TextField bodyDrop;
    @FXML
    private TextField headDrop;
    // End Equipment
    // Movement
    @FXML
    private TextField motionTextX;
    @FXML
    private TextField motionTextY;
    @FXML
    private TextField motionTextZ;
    @FXML
    private TextField directionTextX;
    @FXML
    private TextField directionTextY;
    @FXML
    private TextField directionTextZ;
    // End Movement
    // Additional
    @FXML
    private ToggleButton nameVisible;
    @FXML
    private ToggleButton pickupLoot;
    @FXML
    private ToggleButton creeperLightning;
    @FXML
    private ToggleButton persistenceRequired;
    @FXML
    private ToggleButton invulnerable;
    @FXML
    private ToggleButton angry;
    @FXML
    private CheckBox customName;
    @FXML
    private CheckBox currentHealth;
    @FXML
    private CheckBox fuse;
    @FXML
    private CheckBox creeperRadius;
    @FXML
    private CheckBox fire;
    @FXML
    private CheckBox blastRadius;
    @FXML
    private CheckBox mobSize;
    @FXML
    private TextField customNameText;
    @FXML
    private TextField currentHealthText;
    @FXML
    private TextField fuseText;
    @FXML
    private TextField creeperRadiusText;
    @FXML
    private TextField fireText;
    @FXML
    private TextField blastRadiusText;
    @FXML
    private TextField mobSizeText;
    @FXML
    private CheckBox sandID;
    @FXML
    private TextField sandIDText;
    @FXML
    private CheckBox sandDamage;
    @FXML
    private TextField sandDamageText;
    @FXML
    private ToggleButton sandTime;
    @FXML
    private ToggleButton sandItem;
    @FXML
    private CheckBox villagerColor;
    @FXML
    private ChoiceBox<Integer> villagerColorSelect;
    // End Additional
    // Command Tab
    @FXML
    private Button commandButton;
    @FXML
    private TextArea commandTextArea;
    @FXML
    private ImageView commandBlockImage;
    // End Command Tab

    @FXML
    private AnchorPane container;

    @FXML
    private Label versionText;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        versionText.setText("Summon Command Creator " + SummonCommandCreator.VERSION + " by FirstWorldAnarchy.");
        container.setCursor(Cursor.DISAPPEAR);
        
        entitySelect.getItems().addAll(Arrays.asList(entityOptions));
        entitySelect.getSelectionModel().select(0);
        for (int i = 1; i <= 23; i++) {
            potionId.getItems().add(i);
        }
        potionId.getSelectionModel().select(0);
        for (int i = 0; i <= 22; i++) {
            potionReference.getItems().add((i + 1) + ": " + potionIds[i]);
        }
        sandTime.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
                    Boolean oldValue, Boolean newValue) {
                sandTime.setText(sandTime.isSelected() ? "1" : "0");
            }
        });
        sandItem.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable,
                    Boolean oldValue, Boolean newValue) {
                sandItem.setText(sandItem.isSelected() ? "Yes" : "No");
            }
        });
        villagerColorSelect.setItems(FXCollections.observableArrayList(0, 1, 2,
                3, 4, 5));
        villagerColorSelect.getSelectionModel().select(0);

        creeperImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                FlipTransition ht = new FlipTransition(creeperImage);
                ht.play();
            }
        });
        zombieImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                FlipTransition ht = new FlipTransition(zombieImage);
                ht.play();
            }
        });
        commandBlockImage.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                RollOutTransition rollTrans = new RollOutTransition(commandBlockImage);
                rollTrans.play();
                if (createCommand() != null) {
                    Timeline timeline = new Timeline();
                    String type = "";
                    for (int i = 0; i < createCommand().length(); i++) {
                        type += createCommand().substring(i, i + 1);
                        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(i * 25), new KeyValue(commandTextArea.textProperty(), type)));
                    }
                    timeline.play();
                } else {
                    showCommand();
                }
                rollTrans.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent e) {
                        RollInTransition rollinTrans = new RollInTransition(commandBlockImage);
                        rollinTrans.play();
                    }
                });
                // showCommand();
            }
        });
    }

    public void addPotion() {
        try {
            PotionEffect pe = new PotionEffect(potionId.getSelectionModel()
                    .getSelectedItem(), Integer.parseInt(potionDurationText
                            .getText()), Integer.parseInt(potionAmpText.getText()),
                    potionAmbient.isSelected());
            currentPotionsList.add(pe);
            StringBuilder potion = new StringBuilder();
            potion.append(
                    potionIds[potionId.getSelectionModel().getSelectedItem() - 1])
                    .append(" - ");
            potion.append("Duration: ").append(potionDurationText.getText())
                    .append(", Level: ");
            potion.append(potionAmpText.getText()).append(", ");
            potion.append("Ambient: ").append(potionAmbient.isSelected());
            potionCurrent.getItems().add(potion.toString());
        } catch (NumberFormatException e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "You must enter a number!", "Not a number!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String createCommand() {
        potionCurrent.getItems().clear();
        if (!entitySelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("None")) {
            StringBuilder sb = new StringBuilder();
            sb.append("/summon ");
            sb.append(entitySelect.getSelectionModel().getSelectedItem()).append(
                    " ");
            sb.append(xPos.getText()).append(" ").append(yPos.getText())
                    .append(" ").append(zPos.getText()).append(" ");
            sb.append("{");
            if (getAttributeText() != null) {
                sb.append(getAttributeText());
            }
            if (getEquipmentText() != null) {
                sb.append(getEquipmentText());
            }
            if (getDropChancesText() != null) {
                sb.append(getDropChancesText());
            }
            if (getPotionEffectsText() != null) {
                sb.append(getPotionEffectsText());
            }
            if (getMotionText() != null) {
                sb.append(getMotionText());
            }
            if (!getAdditionalText().equalsIgnoreCase("")) {
                sb.append(getAdditionalText());
            }
            sb.append("}");
            return sb.toString();
        }
        return null;
    }

    public void showCommand() {
        if (createCommand() == null) {
            Timeline t = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(commandTextArea.promptTextProperty(), "You didn't select anything to summon!")), new KeyFrame(Duration.millis(3000), new KeyValue(commandTextArea.promptTextProperty(), "Click on \"Create Command\" or the command block!")));
            t.play();
            
        } else {
            commandTextArea.setText(createCommand());
        }
    }

    public String getAttributeText() {
        if (attributesCheck.isSelected()) {
            StringBuilder att = new StringBuilder();
            att.append("Attributes:[");
            if (attributeMove.isSelected()) {
                att.append("{Name:generic.movementSpeed,Base:");
                att.append(attributeMoveText.getText()).append("},");
            }
            if (attributeHealth.isSelected()) {
                att.append("{Name:generic.maxHealth,Base:");
                att.append(attributeHealthText.getText()).append("},");
            }
            if (attributeKnock.isSelected()) {
                att.append("{Name:generic.knockbackResistance,Base:");
                att.append(attributeKnockText.getText()).append("},");
            }
            if (attributeRange.isSelected()) {
                att.append("{Name:generic.followRange,Base:");
                att.append(attributeRangeText.getText()).append("},");
            }
            if (attributeDmg.isSelected()) {
                att.append("{Name:generic.attackDamage,Base:");
                att.append(attributeDmgText.getText()).append("},");
            }
            att.append("],");
            return att.toString();
        }
        return null;
    }

    public String getEquipmentText() {
        if (equipmentCheck.isSelected()) {
            StringBuilder equip = new StringBuilder();
            equip.append("Equipment:[");
            equip.append("{id:").append(handText.getText()).append("},");
            equip.append("{id:").append(feetText.getText()).append("},");
            equip.append("{id:").append(legsText.getText()).append("},");
            equip.append("{id:").append(bodyText.getText()).append("},");
            equip.append("{id:").append(headText.getText()).append("},");
            equip.append("],");
            return equip.toString();
        }
        return null;
    }

    public String getDropChancesText() {
        if (dropChanceCheck.isSelected()) {
            StringBuilder drop = new StringBuilder();
            drop.append("DropChances:[");
            drop.append(handDrop.getText()).append("f,");
            drop.append(feetDrop.getText()).append("f,");
            drop.append(legsDrop.getText()).append("f,");
            drop.append(bodyDrop.getText()).append("f,");
            drop.append(headDrop.getText()).append("f,");
            drop.append("],");
            return drop.toString();
        }
        return null;
    }

    public String getPotionEffectsText() {
        if (currentPotionsList.size() >= 1) {
            StringBuilder potion = new StringBuilder();
            potion.append("ActiveEffects:[");
            for (PotionEffect pe : currentPotionsList) {
                potion.append("{Ambient:").append(pe.isAmbient() ? "1," : "0,");
                potion.append("Amplifier:").append(pe.getLevel()).append(",");
                potion.append("Duration:").append(pe.getDuration()).append(",");
                potion.append("Id:").append(pe.getId()).append("},");
            }
            potion.append("],");
            return potion.toString();
        }
        return null;
    }

    public String getMotionText() {
        StringBuilder motion = new StringBuilder();
        StringBuilder direction = new StringBuilder();
        motion.append("Motion:[");
        if (!motionTextX.getText().equalsIgnoreCase("0.0")) {
            motion.append(motionTextX.getText()).append(",");
        }
        if (!motionTextY.getText().equalsIgnoreCase("0.0")) {
            motion.append(motionTextY.getText()).append(",");
        }
        if (!motionTextZ.getText().equalsIgnoreCase("0.0")) {
            motion.append(motionTextZ.getText());
        }
        motion.append("],");

        direction.append("direction:[");
        direction.append(directionTextX.getText()).append(",");
        direction.append(directionTextY.getText()).append(",");
        direction.append(directionTextZ.getText());
        direction.append("],");

        if (!motion.toString().equalsIgnoreCase("Motion:[],")) {
            return motion.toString() + direction.toString();
        } else {
            if (entitySelect.getSelectionModel().getSelectedItem().equalsIgnoreCase("witherskull")) {
                return direction.toString();
            } else {
                return null;
            }
        }
    }

    public String getAdditionalText() {
        StringBuilder additonal = new StringBuilder();
        if (customName.isSelected()) {
            additonal.append("CustomName:\"").append(customNameText.getText())
                    .append("\",");
            if (nameVisible.isSelected()) {
                additonal.append("CustomNameVisible:1,");
            }
        }
        if (pickupLoot.isSelected()) {
            additonal.append("CanPickUpLoot:1,");
        }
        if (creeperLightning.isSelected()) {
            additonal.append("powered:1,");
        }
        if (persistenceRequired.isSelected()) {
            additonal.append("PersistenceRequired:1,");
        }
        if (invulnerable.isSelected()) {
            additonal.append("Invulnerable:1,");
        }
        if (angry.isSelected()) {
            additonal.append("Anger:1,");
        }
        if (currentHealth.isSelected()) {
            additonal.append("HealF:").append(currentHealthText.getText())
                    .append(",");
        }
        if (fuse.isSelected()) {
            additonal.append("Fuse:").append(fuseText.getText()).append(",");
        }
        if (creeperRadius.isSelected() || blastRadius.isSelected()) {
            additonal
                    .append("ExplosionRadius:")
                    .append(creeperRadius.isSelected() ? creeperRadiusText
                            .getText() : blastRadiusText.getText()).append(",");
        }
        if (fire.isSelected()) {
            additonal.append("Fire:").append(fireText.getText()).append(",");
        }
        if (mobSize.isSelected()) {
            additonal.append("Size:").append(mobSizeText.getText()).append(",");
        }
        if (sandID.isSelected()) {
            additonal.append("Block:").append(sandIDText.getText()).append(",");
        }
        if (sandTime.isSelected()) {
            additonal.append("Time:1").append(",");
        }
        if (sandItem.isSelected()) {
            additonal.append("DropItem:1");
        }
        if (sandDamage.isSelected()) {
            additonal.append("Data:").append(sandDamageText.getText()).append(",");
        }
        if (villagerColor.isSelected()) {
            additonal.append("Profession:").append(villagerColorSelect.getSelectionModel().getSelectedItem());
        }
        return additonal.toString();
    }

}
