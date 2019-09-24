/**
 * 
 */

/** Bootstrap Date Picker function 
$('#datepicker').datepicker({
	format: 'MM-DD-YYYY'
});
**/


/** SSN formatting function **/
document.getElementById("ssn").onkeyup = function() {
  var val = this.value.replace(/\D/g, '');
  var newVal = '';

  if(val.length > 4) {
    this.value = val;
  }

  if((val.length > 3) && (val.length < 6)) {
    newVal += val.substr(0, 3) + '-';
    val = val.substr(3);
  }

  if (val.length > 5) {
    newVal += val.substr(0, 3) + '-';
    newVal += val.substr(3, 2) + '-';
    val = val.substr(5);
  }

  newVal += val;
  this.value = newVal;
};



/** Phone formatting function **/
document.getElementById("primaryPhone").onkeyup = function() {
  var val = this.value.replace(/\D/g, '');
  var newVal = '';

  if(val.length > 4) {
    this.value = val;
  }

  if((val.length > 3) && (val.length < 7)) {
    newVal += val.substr(0, 3) + '-';
    val = val.substr(3);
  }

  if (val.length > 6) {
    newVal += val.substr(0, 3) + '-';
    newVal += val.substr(3, 3) + '-';
    val = val.substr(6);
  }

  newVal += val;
  this.value = newVal;
};


/** Phone formatting function **/
document.getElementById("secondaryPhone").onkeyup = function() {
  var val = this.value.replace(/\D/g, '');
  var newVal = '';

  if(val.length > 4) {
    this.value = val;
  }

  if((val.length > 3) && (val.length < 7)) {
    newVal += val.substr(0, 3) + '-';
    val = val.substr(3);
  }

  if (val.length > 6) {
    newVal += val.substr(0, 3) + '-';
    newVal += val.substr(3, 3) + '-';
    val = val.substr(6);
  }

  newVal += val;
  this.value = newVal;
};