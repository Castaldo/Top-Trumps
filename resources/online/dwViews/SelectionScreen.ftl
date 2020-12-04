<html>
<head>
<!-- Web page title -->
<title>Top Trumps - Home</title>

<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<style>

			<style>

            .container {
              position: relative;
              width: 100%;
              max-width: 400px;

            }

            .container .btn {
              position: absolute;
              top: 35%;
              left: 48%;
              background-color: #f1f1f1;
              color: black;
              font-size: 16px;
              padding: 16px 30px;
              border: none;
              cursor: pointer;
              border-radius: 5px;
              text-align: center;

            }

            .container .btn:hover {
              background-color: black;
              color: white;

            }

         .center {

           padding: 70px 0;
           text-align: center;
           font-family: "Arial Black", Gadget, sans-serif;
           font-size: 50px;
           letter-spacing: 1.8px;
           word-spacing: 2.4px;
           color: #000000;
           font-weight: 700;
           text-decoration: none;
           font-style: italic;
           font-variant: normal;
           text-transform: uppercase;
           color: white;

           }

           .sub-center {

            position: absolute;
            left: 35%;
            top: 25%;
            font-family: "Arial Black", Gadget, sans-serif;
            font-size: 27px;
            letter-spacing: 1.8px;
            word-spacing: 2.4px;
            color: #000000;
            font-weight: 700;
            text-decoration: none;
            font-style: italic;
            font-variant: normal;
            text-transform: uppercase;
            color: white;

                      }

           html, body {
               min-height: 100%;

           }

           body {
               background-image: url(https://cdn.pixabay.com/photo/2015/12/17/05/21/star-1096934_1280.jpg);
               background-repeat: no-repeat;
               background-position: 0 0;
               background-size: 100%;

           }

           @media (min-width: 1120px), (min-height: 630px) {
               body { background-size: auto; }
           }

            </style>
            </head>
            <body>

            <div class="container">

                <button class="btn" style="left: 35%;" onclick="window.location.href ='http://localhost:7777/toptrumps/game'; + startGame();">Play</button>
                <button class="btn" onclick="window.location.href= 'http://localhost:7777/toptrumps/stats';">View Statistics</button>
                <div class="center">Top Trumps</div>
                <div class="sub-center">Age of Empires</div>

            </div>

	<script type="text/javascript">

       // Method that is called on page load
       function initalize() {

        }

        startGame();


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
        function startGame() {

            // First create a CORS request, this is the message we are going to send (a get request in this case)
            var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/startGame"); // Request type and URL

            // Message is not sent yet, but we can check that the browser supports CORS
            if (!xhr) {
               lert("CORS not supported");

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
