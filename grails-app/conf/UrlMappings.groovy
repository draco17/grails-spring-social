class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
		
		name connect: "/connect/${providerId}" {
		            controller = 'connect'
		            action = [GET: "oauthCallback", POST: 'withProvider', DELETE: "disconnect",]
		        }

	}
}
