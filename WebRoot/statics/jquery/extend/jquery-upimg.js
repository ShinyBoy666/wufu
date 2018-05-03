$(function () {
    var app = angular.module('app', ['localResizeIMG']);
    app.controller('appCtrl', function ($scope) {
        $scope.ok = function (stop, data) {
            data.original.size = (data.original.size / 1024).toFixed(2);
            $scope.$apply();

            setTimeout(function () {
                stop();
            }, 1000);
        };
    });
    angular.bootstrap(document, ['app']);

    $.fn.extend({
        upImg: function () {
            var url = "";
            var base64Img1 = this.attr("ng-src");
            if (base64Img1 != "") {
                base64Img1 = this.attr("ng-src").split(",")[1];
            }
            base64Img1 = base64Img1 || "";
            if (base64Img1 == "") {
                return "";
            }
            $.ajax({
                type: "post",
                url: "/dispatcher.htm?callback=?",
                data: new AjaxData(1025, { customerId: 0, base64String: base64Img1, imgType: 1 }),
                async: false,
                success: function (img) {
                    if (img != "") {
                        url = img;
                    } else {
                        layer.msg("上传失败！", {
                            icon: 2,
                            time: 2000
                        });
                    }
                },
                error: function (msg, textStatus, errorThrown) {
                    layer.msg("上传失败！", {
                        icon: 2,
                        time: 2000
                    });
                }
            });
            return url;
        }
    });
});