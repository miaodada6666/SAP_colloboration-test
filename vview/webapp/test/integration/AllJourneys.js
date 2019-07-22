jQuery.sap.require("sap.ui.qunit.qunit-css");
jQuery.sap.require("sap.ui.thirdparty.qunit");
jQuery.sap.require("sap.ui.qunit.qunit-junit");
QUnit.config.autostart = false;

// We cannot provide stable mock data out of the template.
// If you introduce mock data, by adding .json files in your webapp/localService/mockdata folder you have to provide the following minimum data:
// * At least 3 Collaborationtype in the list

sap.ui.require([
	"sap/ui/test/Opa5",
	"my/bookshop/vview/test/integration/pages/Common",
	"sap/ui/test/opaQunit",
	"my/bookshop/vview/test/integration/pages/App",
	"my/bookshop/vview/test/integration/pages/Browser",
	"my/bookshop/vview/test/integration/pages/Master",
	"my/bookshop/vview/test/integration/pages/Detail",
	"my/bookshop/vview/test/integration/pages/Create",
	"my/bookshop/vview/test/integration/pages/NotFound"
], function (Opa5, Common) {
	"use strict";
	Opa5.extendConfig({
		arrangements: new Common(),
		viewNamespace: "my.bookshop.vview.view."
	});

	sap.ui.require([
		"my/bookshop/vview/test/integration/MasterJourney",
		"my/bookshop/vview/test/integration/NavigationJourney",
		"my/bookshop/vview/test/integration/NotFoundJourney",
		"my/bookshop/vview/test/integration/BusyJourney",
		"my/bookshop/vview/test/integration/FLPIntegrationJourney"
	], function () {
		QUnit.start();
	});
});