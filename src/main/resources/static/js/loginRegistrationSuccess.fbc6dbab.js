(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["loginRegistrationSuccess"], {
    "0049": function (t, n, s) {
        "use strict";
        var e = s("50bb"), o = s.n(e);
        o.a
    }, "50bb": function (t, n, s) {
    }, "84b6": function (t, n, s) {
        "use strict";
        s.r(n);
        var e = function () {
            var t = this, n = this, s = n.$createElement, e = n._self._c || s;
            return e("div", {staticClass: "Login-Registration-Success"}, [e("p", {staticClass: "Login-Registration-Success__message"}, [n._v(" Вы успешно зарегистрировались! ")]), e("BaseButton", {
                attrs: {
                    onClickButton: function () {
                        return t.$router.push("/login")
                    }
                }
            }, [n._v("Войти")])], 1)
        }, o = [], i = (s("99af"), s("d3b7"), function () {
            return s.e("baseButton").then(s.bind(null, "82ea"))
        }), u = {
            components: {BaseButton: i}, metaInfo: function () {
                return {title: this.blogInfo ? "Вы зарегистрированы | ".concat(this.blogInfo.title, " - ").concat(this.blogInfo.subtitle) : "Вы зарегистрированы"}
            }
        }, c = u, a = (s("0049"), s("2877")), l = Object(a["a"])(c, e, o, !1, null, null, null);
        n["default"] = l.exports
    }
}]);
//# sourceMappingURL=loginRegistrationSuccess.fbc6dbab.js.map