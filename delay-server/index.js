const express = require('express');
const app = express()
const port = 3000

app.get('/delay-me/:delay', (req, res) => {
	const delay = req.params.delay;
	setTimeout(function() {
		let response = `delay ${delay} finished`
		console.log(response);
	  res.send();
	}, delay);
})

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})
