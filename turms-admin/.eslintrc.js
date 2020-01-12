module.exports = {
    root: true,
    env: {
        browser: true,
        node: true
    },
    parserOptions: {
        parser: 'babel-eslint'
    },
    extends: [
        'plugin:vue/recommended',
        'eslint:recommended'
    ],
    rules: {
        'quotes': ['error', 'single'],
        'semi': ['error', 'always'],
        'indent': ['error', 4],
        'comma-dangle': ['error', 'never'],
        'prefer-const': ['error'],
        'no-var': ['error'],
        'array-element-newline': ['error', 'consistent'],
        'vue/html-indent': ['error', 4, {
            'attribute': 1,
            'baseIndent': 1,
            'closeBracket': 0,
            'alignAttributesVertically': false,
            'ignores': []
        }],
        'vue/max-attributes-per-line': ['error', {
            'singleline': 1,
            'multiline': {
                'max': 1,
                'allowFirstLine': false
            }
        }],
        "vue/name-property-casing": ["error", "kebab-case"],
        'vue/html-closing-bracket-spacing': ['error'],
        'vue/no-static-inline-styles': ['error']
    }
};
