var exec = require('cordova/exec');

//default autocreated function.
exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'mathcal', 'coolMethod', [arg0]);
};

// add function.
module.exports.add = function(args,success,error){

    exec(success,error,'mathcal','add',[args]);

};

// substract function.
module.exports.substract = function(args,success,error){

    exec(success,error,'mathcal','substract',[args]);

};
