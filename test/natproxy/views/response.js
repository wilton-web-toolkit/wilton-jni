/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([
    "wilton/shared",
    "wilton/db/DBConnection",
    "wilton/natproxy/proxy"
], function(shared, DBConnection, proxy) {
    "use strict";

    var conf = shared.get("wilton.test.natproxy.config");
    var dbConn = new DBConnection(conf.dbUrl);

    return {
        POST: function(req) {
            proxy.postResponse({
                dbConn: dbConn, 
                req: req
            });
        }
    };
});
