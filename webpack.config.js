const path = require('path');

module.exports = {

  entry: './src/main/js/index.js',

  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, 'dist')
  },

  module: {
    rules: [
      {
        test: /\.jsx?$/,
        use: [ 'babel-loader' ],
        exclude: /node_modules/,
      },
      {
        test: /\.css$/,
        use: [ 'css-loader' ],
        exclude: /node_modules/,
      },
    ]
  },

  devServer: {
    contentBase: path.join(__dirname, 'web'),
  },
};
