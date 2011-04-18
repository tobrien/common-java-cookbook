project {
    modelVersion '4.0.0'
    groupId 'com.discursive.cjcook'
    artifactId 'cjcook-parent'
    version '0.27-SNAPSHOT'
    packaging 'pom'
    name 'Common Java Cookbook'
    description 'A Common Cookbook for Java'
    url 'http://www.discursive.com/books/cjcook'
    organization {
        name 'Discursive'
        url 'http://www.discursive.com'
    }
    developers {
        developer {
            id 'tobrien'
            name 'Tim O\'Brien'
            email 'tobrien@discursive.com'
            organization 'Discursive'
            organizationUrl 'http://www.discursive.com'
            roles {
                role 'Author'
            }
        }
    }
    modules {
        module 'cjcook-content'
        module 'cjcook-examples'
        module 'cjcook-html'
        module 'cjcook-single-html'
        module 'cjcook-pdf'
        module 'cjcook-epub'
        module 'cjcook-site'
    }
    scm {
        connection 'scm:git:git@github.com:tobrien/common-java-cookbook.git'
        developerConnection 'scm:git:git@github.com:tobrien/common-java-cookbook.git'
        url 'scm:git:git@github.com:tobrien/common-java-cookbook.git'
    }
    distributionManagement {
        repository {
            id 'discursive-private-releases'
            name 'Discursive Releases'
            url 'http://build.discursive.com/nexus/content/repositories/discursive-releases/'
        }
        snapshotRepository {
            id 'discursive-private-snapshots'
            name 'Discursive Snapshots'
            url 'http://build.discursive.com/nexus/content/repositories/discursive-private-snapshots/'
        }
    }
    properties {
        'organization.address' '626 Grove St., Suite 201, Evanston, IL 60202'
        'organization.logo' '../images/discursive-logo.png'
        'junit.version' '3.8.1'
        'book.title' 'Common Java Cookbook'
        'googleguava.version' 'r07'
        'organization.slogan' 'Discursive'
        'docbkx-tools.version' '2.0.13-tobrien-SNAPSHOT'
        'copyright.year' '2009'
        'google.analytics.id' 'UA-67332-11'
        'commons.site' 'http://commons.apache.org/'
        'book.subtitle' 'A Common Cookbook for Java'
    }
    dependencies {
        dependency {
            groupId 'junit'
            artifactId 'junit'
            version '${junit.version}'
        }
    }
    build {
        extensions {
            extension {
                groupId 'org.apache.maven.wagon'
                artifactId 'wagon-ssh'
                version '1.0-beta-6'
            }
        }
        pluginManagement {
            plugins {
                plugin {
                    artifactId 'maven-install-plugin'
                    version '2.2'
                }
                plugin {
                    artifactId 'maven-site-plugin'
                    version '2.0-beta-7'
                }
                plugin {
                    artifactId 'maven-deploy-plugin'
                    version '2.4'
                }
                plugin {
                    artifactId 'maven-clean-plugin'
                    version '2.2'
                }
                plugin {
                    artifactId 'maven-release-plugin'
                    version '2.0-beta-9'
                }
            }
        }
        plugins {
            plugin {
                artifactId 'maven-release-plugin'
                version '2.0-beta-9'
                configuration {
                    allowTimestampedSnapshots 'true'
                    autoVersionSubmodules 'true'
                    goals 'clean deploy'
                    releaseProfiles 'publish'
                    preparationGoals 'clean install'
                    useReleaseProfile 'false'
                }
            }
        }
    }
    profiles {
        profile {
            id 'publish'
            distributionManagement {
                site {
                    id 'discursive-site'
                    name 'Discursive Site'
                    url 'scp://deployer@mars.discursive.com/var/www/html/www.discursive.com/books/cjcook/parent'
                }
            }
        }
        profile {
            id 'stage'
            distributionManagement {
                site {
                    id 'discursive-site'
                    name 'Discursive Site'
                    url 'scp://deployer@mars.discursive.com/var/www/html/www.discursive.com/books/cjcook-stage/parent'
                }
            }
        }
    }
}
