jQuery.sap.require("sap.ui.qunit.qunit-css");
jQuery.sap.require("sap.ui.thirdparty.qunit");
jQuery.sap.require("sap.ui.qunit.qunit-junit");
QUnit.config.autostart = false;

sap.ui.require([
	"sap/ui/test/Opa5",
	"my/bookshop/vview/test/integration/pages/Common",
	"sap/ui/test/opaQunit",
	"my/bookshop/vview/test/integration/pages/App",
	"my/bookshop/vview/test/integration/pages/Browser",
	"my/bookshop/vview/test/integration/pages/Master",
	"my/bookshop/vview/test/integration/pages/Detail",
	"my/bookshop/vview/test/integration/pages/NotFound"
], function (Opa5, Common) {
	"use strict";
	Opa5.extendConfig({
		arrangements: new Common(),
		viewNamespace: "my.bookshop.vview.view."
	});

	sap.ui.require([
		"my/bookshop/vview/test/integration/NavigationJourneyPhone",
		"my/bookshop/vview/test/integration/NotFoundJourneyPhone",
		"my/bookshop/vview/test/integration/BusyJourneyPhone"
	], function () {
		QUnit.start();
	});
});