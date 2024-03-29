module.exports = {
    // https://cli.vuejs.org/config/#devserver-proxy
    devServer: {
        port: 8080,
        proxy: {
            '/api': {
                target: 'http://localhost:8000',
                ws: true,
                changeOrigin: true
            }
        }
    }
}