(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["addText"], {
    "42ff": function (t, e, s) {
        "use strict";
        var i = s("4f50"), n = s.n(i);
        n.a
    }, "4f50": function (t, e, s) {
    }, ce13: function (t, e, s) {
        "use strict";
        s.r(e);
        var i = function () {
            var t = this, e = t.$createElement, s = t._self._c || e;
            return s("div", {
                staticClass: "AddText",
                class: t.className
            }, [s("div", {staticClass: "AddText-Edit"}, [s("Vueditor", {ref: "editor"})], 1)])
        }, n = [], r = s("ccb6"), o = {
            props: {className: {type: String, required: !1}, value: {type: String, required: !1}},
            data: function () {
                return {editorUnsubscribe: null, lastText: null}
            },
            watch: {
                value: function (t) {
                    this.$refs.editor.setContent(t)
                }
            },
            methods: {
                focus: function () {
                    this.$refs.editor.focus()
                }
            },
            mounted: function () {
                var t = this;
                this.$refs.editor.setContent(this.value), this.editorUnsubscribe = this.$refs.editor.$store.subscribe((function (e, s) {
                    "UPDATE_CONTENT" === e.type && t.lastText !== s.content && (t.lastText = s.content, t.$emit("input", s.content))
                })), Object(r["a"])(this.$refs.editor, this.$store)
            },
            beforeDestroy: function () {
                this.editorUnsubscribe && this.editorUnsubscribe()
            }
        }, c = o, u = (s("42ff"), s("2877")), a = Object(u["a"])(c, i, n, !1, null, null, null);
        e["default"] = a.exports
    }
}]);
//# sourceMappingURL=addText.3b2c4c96.js.map