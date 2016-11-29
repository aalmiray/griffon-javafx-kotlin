package org.example

import griffon.core.artifact.GriffonController
import griffon.inject.MVCMember
import griffon.metadata.ArtifactProviderFor
import org.codehaus.griffon.runtime.core.artifact.AbstractGriffonController
import griffon.transform.Threading
import javax.annotation.Nonnull

@ArtifactProviderFor(GriffonController::class)
class SampleController : AbstractGriffonController() {
    @set:[MVCMember Nonnull]
    lateinit var model: SampleModel

    @Threading(Threading.Policy.INSIDE_UITHREAD_ASYNC)
    fun click() {
        val count = Integer.parseInt(model.clickCount)
        model.clickCount = (count + 1).toString()
    }
}