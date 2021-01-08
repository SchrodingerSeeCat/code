const { override, fixBabelImports, addLessLoader  } = require('customize-cra');

module.exports = override(
	fixBabelImports('import', {
		libraryName: 'antd',
		libraryDirectory: 'es',
		style: true,
	}),
	addLessLoader({
		lessOptions: {
			javascriptEnabled: true, // 允许使用js修改主题颜色
			modifyVars: { '@primary-color': 'orange' }, // 修改主题的颜色
		}
	}),
);