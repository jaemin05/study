module.exports = {
    plugins: ['prettier'],
    extends: [
        // I don't want to write airbnb style! don't be nosy! :)
        'eslint:recommended',
        'plugin:prettier/recommended',
    ],
    parserOptions: {
        ecmaVersion: 9, // ES9:ES2018 to use ... operator
        sourceType: 'script', // no module option
        ecmaFeatures: {
            jsx: false, // no jsx
            experimentalObjectRestSpread: true, // use ... operator
        },
    },
    env: {
        browser: false, // no browser object
        node: true, // node env
        commonjs: true,
    },
    ignorePatterns: [
        'node_modules/', // ignore eslint
    ],
    rules: {
        'prettier/prettier': [
            'error',
            {
                usePrettierrc: true,
            },
        ], // following prettier rules
    },
};
   