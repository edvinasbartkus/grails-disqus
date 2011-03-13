import org.codehaus.groovy.grails.commons.ConfigurationHolder

class DisqusGrailsPlugin {
    // the plugin version
    def version = "0.1"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "1.3.6 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "Edvinas Bartkus"
    def authorEmail = "edvinas@geeks.lt"
    def title = "Embed Disqus system into your application"
    def description = '''\\
To simplify the usage of Disqus you can use this plugin. Simple add disqus tag into the pages
where you want to allow users to comment stuff.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/disqus"

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before 
    }

    def doWithSpring = {
      GroovyClassLoader classLoader = new GroovyClassLoader(getClass().getClassLoader())
      ConfigObject defaultConfig
      try {
        defaultConfig = new ConfigSlurper().parse(classLoader.loadClass("DefaultDisqusConfig"))
      } catch(Exception e) {
        throw new RuntimeException("Couldn't load the disqus default settings.")
      }
      ConfigObject config = ConfigurationHolder.config.grails.plugins.disqus
      ConfigurationHolder.config.grails.plugins.disqus = defaultConfig.disqus.merge(config)
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }
}
