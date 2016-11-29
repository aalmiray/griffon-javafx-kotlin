import griffon.util.AbstractMapResourceBundle

class Config : AbstractMapResourceBundle() {
    override fun initialize(entries: MutableMap<String, Any>) {
        entries.put("application", hashMapOf(
                "title" to "sample",
                "startupGroups" to listOf("sample"),
                "autoshutdown" to true
        ))
        entries.put("mvcGroups", hashMapOf(
                "sample" to hashMapOf(
                        "model" to "org.example.SampleModel",
                        "view" to "org.example.SampleView",
                        "controller" to "org.example.SampleController"
                )
        ))
    }
}