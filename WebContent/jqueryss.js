/*
  This is a jQuery script for 2-step checkbox filtering
  I'll be explaining lines that seems to have importance
  Please note that the 2nd Block of checkboxes must be disabled in the html via attribute 'disabled'
*/

//show all categories
var _showCategories = function(item) {
  for (var x = 0; x < item.length; ++x) {
    $(item[x]).fadeIn();
  }
};

//categories array will be used to store the parent ID of each .results block
//the resources array will hold all the input[type="checkbox"]:checked values
//the initial will be used as a string container to target the specific result that needs to be displayed
var categories = [],
  resources = [],
  initial = "";

//list all the category blocks
categories[0] = "#category-one";
categories[1] = "#category-two";
categories[2] = "#category-three";
categories[3] = "#category-four";
categories[4] = "#category-five";
categories[5] = "#category-mix";
categories[6] = "#topics-mix";
categories[7] = "#mixed";

$('div.tags').find('input[type="checkbox"]').click(function() {
  
  //everytime there is a new category/clicked
  //remove values from the resources array and initial variable
  //to remove duplication of entries
  resources = [];
  initial = "";
  
  //check everything on the first checkbox block if anything is checked
  if ($('div.tags.categories input[type="checkbox"]:checked').length > 0) {
    $('.results li').hide();
    //we remove the attribute on the
    //second checkbox block to be able to filter it
    $('.topics input[type="checkbox"]').removeAttr('disabled');
    
    //in all inputs that are checked, get it's value (rel in this case)
    //check if the value already exists in our resources array
    //if not, put all those values into the array
    $('div.tags').find('input:checked').each(function() {
      if (($.inArray($(this).attr('rel'), resources)) === -1) {
        resources.push($(this).attr('rel'));
      }
      
      //convert our resources array to string
      //then replace the commas (,) with periods (.)
      initial = resources.toString();
      initial = initial.replace(/,/g, '.');
    });    
    
    //iterate through all the categories
    //and check if a category block's li children has the classes 
    //that we inserted in the initial variable
    //else fade the block out
    for (var i = 0; i < categories.length; ++i) {
      if ($(categories[i] + " .results > li." + initial).length != 0) {
        $(".results > li." + initial).show('fast');
        $(categories[i]).fadeIn('fast');
      } else {
        $(categories[i]).fadeOut('fast');
      }
    }
  } else {
    //reset all when all of the checkboxes are unticked
    $('.topics input[type="checkbox"]').attr('disabled', 'disabled');
    $('.results > li').fadeIn('fast');
    _showCategories(categories);
  }
});