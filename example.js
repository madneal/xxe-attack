var Nightmare = require('nightmare');
var nightmare = Nightmare({ show: true });

nightmare
  .goto('http://www.weibo.com/')
  // .type('.gn_search_v2 input', 'github')
  .insert('.gn_search_v2 input', '上海房价')
  .click('.gn_search_v2 a')
  // .type('input[action*="/search"] [name=p]', 'github nightmare')
  // .click('form[action*="/search"] [type=submit]')
  // .wait('#main')
  // .evaluate(function () {
  //   return document.querySelector('#main .searchCenterMiddle li a').href
  // })
  // .end()
  // .then(function (result) {
  //   console.log(result)
  // })
  .catch(function (error) {
    console.error('Search failed:', error);
  });