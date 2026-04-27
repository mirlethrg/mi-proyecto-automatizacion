function fn() {
    // Configuración base para el entorno de pruebas de Karate
    var env = karate.env; 
    karate.log('karate.env system property was:', env);
    if (!env) {
      env = 'dev';
    }
    
    // Aquí puedes tener variaciones por ambiente
    var config = {
      env: env,
      baseUrl: 'http://localhost:8080'
    };
    
    if (env == 'dev') {
        // config para dev
    } else if (env == 'qa') {
        // config para qa 
        config.baseUrl = 'https://qa-api.QA-Engine-Pro.tech';
    }
    
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    
    return config;
}

