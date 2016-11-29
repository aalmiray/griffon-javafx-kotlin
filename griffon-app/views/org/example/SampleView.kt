package org.example;

import griffon.core.artifact.GriffonController
import griffon.core.artifact.GriffonView
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor
import javafx.fxml.FXML
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.paint.Color
import javafx.stage.Stage
import javafx.stage.Window
import org.codehaus.griffon.runtime.javafx.artifact.AbstractJavaFXGriffonView
import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonView::class)
class SampleView : AbstractJavaFXGriffonView() {
    @set:[MVCMember Nonnull]
    lateinit var model: SampleModel
    @set:[MVCMember Nonnull]
    lateinit var controller: SampleController

    lateinit private @FXML var clickLabel: Label

    override fun initUI() {
        val stage: Stage = application.createApplicationContainer(mapOf()) as Stage
        stage.title = application.configuration.getAsString("application.title")
        stage.scene = _init()
        application.getWindowManager<Window>().attach("mainWindow", stage)
    }

    private fun _init(): Scene {
        val scene: Scene = Scene(Group())
        scene.fill = Color.WHITE

        val node = loadFromFXML()
        model.clickCountProperty().bindBidirectional(clickLabel.textProperty());
        (scene.root as Group).children.addAll(node)
        connectActions(node as Any, controller as GriffonController)
        return scene
    }
}
