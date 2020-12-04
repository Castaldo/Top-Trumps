<html>

<head>
    <!-- Web page title -->
    <title>Top Trumps</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <style>


 html, body {

               min-height: 100%;

           }

           body {
               background-image: url(https://cdn.pixabay.com/photo/2017/02/23/15/56/acropolis-2092534_1280.jpg);
               background-repeat: no-repeat;
               background-position: 0 0;
               background-size: 100%;

           }

           .card {
            opacity: 0.9;
            min-width: 140px;
            max-width: 165px;

           }

           .container {
            padding-top:10px;

           }

           .btn {
           position: absolute;
           top: 85%;
           left: 7%;
           background-color: #f1f1f1;
           color: black;
           font-size: 16px;
           padding: 16px 30px;
           border: none;
           cursor: pointer;
           border-radius: 5px;
           text-align: center;
           opacity: 0.9;

            }

           .btn2 {
           position: absolute;
           top: 85%;
           left: 25%;
           background-color: #f1f1f1;
           color: black;
           font-size: 16px;
           padding: 16px 30px;
           border: none;
           cursor: pointer;
           border-radius: 5px;
           text-align: center;
           opacity: 0.9;

            }

           .h6 {
           position: absolute;
           top: 85%;
           left: 60%;
           background-color: #f1f1f1;
           color: black;
           font-size: 16px;
           padding: 16px 35px;
           border: none;
           border-radius: 20px;
           opacity: 0.9;

            }

</style>

</head>

  <body onload="initalize()"
    <div class="container">
      <div class="card-deck">
          <div class="card">
              <div class="card-body">
                  <h5 class="card-title"><span id="player1"><br><br><br></h5>
                  <div class="list-group">
                      <button type="button" onclick="KeyboardSize() + + player2() + +  player3() + +  player4() + +  player5();" class="list-group-item list-group-item-action">Size:<span id="p1Size"></span></button>
                      <button type="button" onclick="KeyboardPop() + + player2() + +  player3() + +  player4() + +  player5();"class="list-group-item list-group-item-action">Pop:<span id="p1Population"></button>
                      <button type="button" onclick="KeyboardAnt() + + player2() + +  player3() + +  player4() + +  player5();"class="list-group-item list-group-item-action">Antiquity:<span id="p1Antiquity"></span></button>
                      <button type="button" onclick="KeyboardDuration() + + player2() + +  player3() + +  player4() + +  player5();"class="list-group-item list-group-item-action">Duration:<span id="p1Duration"></span></button>
                      <button type="button" onclick="KeyboardCool() + + player2() + +  player3() + +  player4() + +  player5();"class="list-group-item list-group-item-action">Cool:<span id="p1Cool"></span></button>
                  </div>
              </div>
              <div class="card-footer">
                  <small class="text-muted">Player 1</small>
              </div>
          </div>
          <div class="card">
              <div class="card-body">
                  <h5 class="card-title"><span id="player2"><br><br><br></h5>
                  <div class="list-group">
                      <button type="button" class="list-group-item list-group-item-action">Size:<span id="p2Size"></span></button>
                      <button type="button" class="list-group-item list-group-item-action">Pop:<span id="p2Population"></button>
                      <button type="button" class="list-group-item list-group-item-action">Antiquity:<span id="p2Antiquity"></span></button>
                      <button type="button" class="list-group-item list-group-item-action">Duration:<span id="p2Duration"></span></button>
                      <button type="button" class="list-group-item list-group-item-action">Cool:<span id="p2Cool"></span></button>
                  </div>
              </div>
              <div class="card-footer">
                  <small class="text-muted">Computer 1</small>
              </div>
          </div>
          <div class="card">
              <div class="card-body">
                  <h5 class="card-title"><span id="player3"><br><br><br></h5>
                  <div class="list-group">
                      <button type="button" class="list-group-item list-group-item-action">Size:<span id="p3Size"></span></button>
                      <button type="button" class="list-group-item list-group-item-action">Pop:<span id="p3Population"></button>
                      <button type="button" class="list-group-item list-group-item-action">Antiquity:<span id="p3Antiquity"></span></button>
                      <button type="button" class="list-group-item list-group-item-action">Duration:<span id="p3Duration"></span></button>
                      <button type="button" class="list-group-item list-group-item-action">Cool:<span id="p3Cool"></span></button>
                  </div>
              </div>
              <div class="card-footer">
                  <small class="text-muted">Computer 2</small>
              </div>
          </div>
          <div class="card">
              <div class="card-body">
                   <h5 class="card-title"><span id="player4"><br><br><br></h5>
                  <div class="list-group">
                     <button type="button" class="list-group-item list-group-item-action">Size<span id="p4Size"></span></button>
                     <button type="button" class="list-group-item list-group-item-action">Pop:<span id="p4Population"></button>
                     <button type="button" class="list-group-item list-group-item-action">Antiquity:<span id="p4Antiquity"></span></button>
                     <button type="button" class="list-group-item list-group-item-action">Duration:<span id="p4Duration"></span></button>
                     <button type="button" class="list-group-item list-group-item-action">Cool:<span id="p4Cool"></span></button>
                  </div>
              </div>
              <div class="card-footer">
                  <small class="text-muted">Computer 3</small>
              </div>
          </div>
          <div class="card">
              <div class="card-body">
                   <h5 class="card-title"><span id="player5"><br><br><br></h5>
                  <div class="list-group">
                      <button type="button" class="list-group-item list-group-item-action">Size<span id="p5Size"></span></button>
                      <button type="button" class="list-group-item list-group-item-action">Pop:<span id="p5Population"></button>
                      <button type="button" class="list-group-item list-group-item-action">Antiquity:<span id="p5Antiquity"></span></button>
                      <button type="button" class="list-group-item list-group-item-action">Duration:<span id="p5Duration"></span></button>
                      <button type="button" class="list-group-item list-group-item-action">Cool:<span id="p5Cool"></span></button>
                  </div>
              </div>
              <div class="card-footer">
                  <small class="text-muted">Computer 4</small>
              </div>
          </div>
          <button class="btn" onclick="getAttributes();">Deal Cards<span id="DealCards" ></span></button>
          <button class="btn2" onclick="window.location.href= 'http://localhost:7777/toptrumps';">Back </button>
          <button class="h6">Next Round:<span id="Round"></button>
          </div>
      </div>
  </div>
  <script type="text/javascript">


			// Method that is called on page load
			function initalize() {

			}

            getAttributes();
            KeyboardSize();
            KeyboardPop();
            KeyboardAnt();
            KeyboardDuration();
            KeyboardCool();
            player2();
            player3();
            player4();
            player5();

			// -----------------------------------------
			// Add your other Javascript methods Here
			// -----------------------------------------

			// This is a reusable method for creating a CORS request. Do not edit this.
			function createCORSRequest(method, url) {
  				var xhr = new XMLHttpRequest();
  				if ("withCredentials" in xhr) {

    				// Check if the XMLHttpRequest object has a "withCredentials" property.
    				// "withCredentials" only exists on XMLHTTPRequest2 objects.
    				xhr.open(method, url, true);

  				} else if (typeof XDomainRequest != "undefined") {

    				// Otherwise, check if XDomainRequest.
    				// XDomainRequest only exists in IE, and is IE's way of making CORS requests.
    				xhr = new XDomainRequest();
    				xhr.open(method, url);

 				 } else {

    				// Otherwise, CORS is not supported by the browser.
    				xhr = null;

  				 }

  				 return xhr;
			}

		</script>

        <!-- Here are examples of how to call REST API Methods -->
        <script type="text/javascript">

			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function getAttributes() {

                // First create a CORS request, this is the message we are going to send (a get request in this case)
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/attributes"); // Request type and URL

                // Message is not sent yet, but we can check that the browser supports CORS
                if (!xhr) {
                  alert("CORS not supported");

                }

                // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
                xhr.onload = function(e) {
                    var responseText = xhr.response; // the text of the response
                    var response = JSON.parse(responseText);

                    // WRITE CODE HERE:
                    $("#p1Size").text(" " + response[0]);
                    $("#p1Population").text(" " + response[1]);
                    $("#p1Antiquity").text(" " + response[2]);
                    $("#p1Duration").text(" " + response[3]);
                    $("#p1Cool").text(" " + response[4]);
                    $("#player1").text(" " + response[5]);

                }

				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();

			}

			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
            function player2() {

              // First create a CORS request, this is the message we are going to send (a get request in this case)
              var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/player2"); // Request type and URL

              // Message is not sent yet, but we can check that the browser supports CORS
              if (!xhr) {
                alert("CORS not supported");

              }

              // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
              xhr.onload = function(e) {
                 var responseText = xhr.response; // the text of the response
                 var response2 = JSON.parse(responseText);

                 // WRITE CODE HERE:
                 $("#p2Size").text(" " + response2[0]);
                 $("#p2Population").text(" " + response2[1]);
                 $("#p2Antiquity").text(" " + response2[2]);
                 $("#p2Duration").text(" " + response2[3]);
                 $("#p2Cool").text(" " + response2[4]);
                 $("#player2").text(" " + response2[5]);

              }

              // We have done everything we need to prepare the CORS request, so send it
               xhr.send();

            }

            // This calls the helloJSONList REST method from TopTrumpsRESTAPI
            function player3() {

                // First create a CORS request, this is the message we are going to send (a get request in this case)
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/player3"); // Request type and URL

                // Message is not sent yet, but we can check that the browser supports CORS
                if (!xhr) {
                    alert("CORS not supported");

                }

                // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
                xhr.onload = function(e) {
                    var responseText = xhr.response; // the text of the response
                    var response3 = JSON.parse(responseText);

                    // WRITE CODE HERE:
                    $("#p3Size").text(" " + response3[0]);
                    $("#p3Population").text(" " + response3[1]);
                    $("#p3Antiquity").text(" " + response3[2]);
                    $("#p3Duration").text(" " + response3[3]);
                    $("#p3Cool").text(" " + response3[4]);
                    $("#player3").text(" " + response3[5]);

                }

                // We have done everything we need to prepare the CORS request, so send it
                xhr.send();

            }

            // This calls the helloJSONList REST method from TopTrumpsRESTAPI
            function player4() {

              // First create a CORS request, this is the message we are going to send (a get request in this case)
              var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/player4"); // Request type and URL

              // Message is not sent yet, but we can check that the browser supports CORS
              if (!xhr) {
                 alert("CORS not supported");

              }

              // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
              xhr.onload = function(e) {
                  var responseText = xhr.response; // the text of the response
                  var response4 = JSON.parse(responseText);

                  // WRITE CODE HERE:
                  $("#p4Size").text(" " + response4[0]);
                  $("#p4Population").text(" " + response4[1]);
                  $("#p4Antiquity").text(" " + response4[2]);
                  $("#p4Duration").text(" " + response4[3]);
                  $("#p4Cool").text(" " + response4[4]);
                  $("#player4").text(" " + response4[5]);

              }

              // We have done everything we need to prepare the CORS request, so send it
              xhr.send();

            }

            // This calls the helloJSONList REST method from TopTrumpsRESTAPI
            function player5() {

                // First create a CORS request, this is the message we are going to send (a get request in this case)
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/player5"); // Request type and URL

                // Message is not sent yet, but we can check that the browser supports CORS
                if (!xhr) {
                    alert("CORS not supported");

                }

                // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
                xhr.onload = function(e) {
                      var responseText = xhr.response; // the text of the response
                      var response5 = JSON.parse(responseText);

                      // WRITE CODE HERE:
                      $("#p5Size").text(" " + response5[0]);
                      $("#p5Population").text(" " + response5[1]);
                      $("#p5Antiquity").text(" " + response5[2]);
                      $("#p5Duration").text(" " + response5[3]);
                      $("#p5Cool").text(" " + response5[4]);
                      $("#player5").text(" " + response5[5]);

                }

                 // We have done everything we need to prepare the CORS request, so send it
                  xhr.send();

             }

		    // This calls the helloJSONList REST method from TopTrumpsRESTAPI
            function KeyboardSize() {

              // First create a CORS request, this is the message we are going to send (a get request in this case)
              var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/value"); // Request type and URL

              // Message is not sent yet, but we can check that the browser supports CORS
              if (!xhr) {
                alert("CORS not supported");

              }

              // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
              xhr.onload = function(e) {
                var responseText = xhr.response; // the text of the response

              };

              // We have done everything we need to prepare the CORS request, so send it
              xhr.send();

            }


            // This calls the helloJSONList REST method from TopTrumpsRESTAPI
            function KeyboardPop() {

                // First create a CORS request, this is the message we are going to send (a get request in this case)
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/value1"); // Request type and URL

                // Message is not sent yet, but we can check that the browser supports CORS
                if (!xhr) {
                    alert("CORS not supported");

                }

                // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
                xhr.onload = function(e) {
                    var responseText = xhr.response; // the text of the response

                };

                // We have done everything we need to prepare the CORS request, so send it
                xhr.send();

            }

             // This calls the helloJSONList REST method from TopTrumpsRESTAPI
             function KeyboardAnt() {

                 // First create a CORS request, this is the message we are going to send (a get request in this case)
                 var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/value2"); // Request type and URL

                 // Message is not sent yet, but we can check that the browser supports CORS
                 if (!xhr) {
                    alert("CORS not supported");

                 }

                 // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
                 xhr.onload = function(e) {
                    var responseText = xhr.response; // the text of the response

                 };

                 // We have done everything we need to prepare the CORS request, so send it
                 xhr.send();

             }

             // This calls the helloJSONList REST method from TopTrumpsRESTAPI
             function KeyboardDuration() {

                // First create a CORS request, this is the message we are going to send (a get request in this case)
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/value3"); // Request type and URL

                // Message is not sent yet, but we can check that the browser supports CORS
                if (!xhr) {
                   alert("CORS not supported");

                }

                // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
                xhr.onload = function(e) {
                  var responseText = xhr.response; // the text of the response

                };

                // We have done everything we need to prepare the CORS request, so send it
                xhr.send();

             }

             // This calls the helloJSONList REST method from TopTrumpsRESTAPI
             function KeyboardCool() {

                // First create a CORS request, this is the message we are going to send (a get request in this case)
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/value4"); // Request type and URL

                // Message is not sent yet, but we can check that the browser supports CORS
                if (!xhr) {
                    alert("CORS not supported");

                }

                // THIS IS WHERE THE MAGIC HAPPENS!!!!!!
                xhr.onload = function(e) {
                    var responseText = xhr.response; // the text of the response

                };

                // We have done everything we need to prepare the CORS request, so send it
                xhr.send();

             }

		</script>
        </body>
</html>