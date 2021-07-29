var scanner = require('sonarqube-scanner');

scanner(
  {
    serverUrl: process.env.SONAR_HOST || 'http://172.27.12.78',

    options: {
      'sonar.projectVersion': '1.1.1',

      'sonar.sources': 'app',

      'sonar.tests': 'test',

      'sonar.exclusions':'/node_modules/** '
      ,
      'sonar.projectName':'Online-Tutor-G10'
    }
  },

  () => {
    // callback is required
  }
);

