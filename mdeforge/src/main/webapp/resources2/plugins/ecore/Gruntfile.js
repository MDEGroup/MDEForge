module.exports = function(grunt) {

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),

        concat: {
            dist: {
                src: [
                    'src/js/diagram/connections/Connections.js',
                    'src/js/diagram/shapes/FeatureShape.js',
                    'src/js/diagram/shapes/EAttributeShape.js',
                /*
                    'src/javascripts/diagram/shapes/EOperationShape.js',
                */
                    'src/js/diagram/shapes/ClassifierShape.js',
                /*
                    'src/javascripts/diagram/shapes/EEnumShape.js',
                    'src/javascripts/diagram/shapes/EDataTypeShape.js',
                */
                    'src/js/diagram/shapes/EClassShape.js',
                /*
                    'src/javascripts/diagram/shapes/EPackageShape.js',
                */
                    'src/js/diagram/EcoreDiagram.js',
                    'src/js/views/navigator/box.js',
                    'src/js/views/navigator/header.js',
                    'src/js/views/navigator/palette.js',
                    'src/js/views/navigator/resources.js',
                    'src/js/views/navigator/properties.js',
                    'src/js/views/navigator/navigator.js',
                    'src/js/views/modals.js',
                    'src/js/views/property.js',
                    'src/js/views/editor.js',
                    'src/js/util/dnd.js',
                    'src/js/app.js'
                ],
                dest: 'assets/app.js'
            }
        },

        less: {
            development: {
                options: {
                    compress: false
                },
                files: { 'assets/css/app.css': 'src/css/**/*.less' }
            }
        },

        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n',
                mangle: true,
                compress: true,
                report: 'gzip'
            },
            build: {
                src: 'assets/app.js',
                dest: 'assets/app.min.js'
            }
        },

        watch: {
            scripts: {
                files: ['src/**/*.js', 'src/**/*.less'],
                tasks: ['build'],
                options: {
                    nospawn: true
                }
            }
        }


    });

    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-contrib-concat');

    grunt.registerTask('build', ['concat', 'uglify', 'less']);
};

