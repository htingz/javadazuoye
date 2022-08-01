

module.exports = {
    devServer: {
        port: 9876,
        hotOnly:true,
        proxy: {
            '/zht': {
                target: 'http://localhost:9091',
                changeOrigin: true,
                ws: true,
                pathRewrite: {
                    '^/zht': ''
                }
            }

        }
    }
}