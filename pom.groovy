project {
    modelVersion '4.0.0'

    groupId 'com.discursive.cjcook'
    artifactId 'cjcook-parent'
    version '0.27-SNAPSHOT'

    packaging 'pom'

    modules 'content', 'examples', 'html', 'single-html', 
            'pdf', 'epub', 'site'

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
    dependencies 'junit:junit:${junit.version'
    build {
        extensions 'org.apache.maven.wagon:wagon-ssh:1.0-beta-6'
        pluginManagement {
            plugins 'org.apache.maven.plugins:maven-install-plugin:2.2',
                    'org.apache.maven.plugins:maven-site-plugin:2.0-beta-7',
                    'org.apache.maven.plugins:maven-deploy-plugin:2.4',
                    'org.apache.maven.plugins:maven-clean-plugin:2.2',
                    'org.apache.maven.plugins:maven-release-plugin:2.0-beta-9'
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
}
