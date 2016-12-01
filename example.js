var Nightmare = require('nightmare');
var options = {
  show: true,
  executionTimeout: 80000000
};
var nightmare = Nightmare(options);

nightmare
  .goto('http://www.weibo.com/')
  .wait('.gn_search_v2 input')
  // .type('.gn_search_v2 input', 'github')
  .insert('.gn_search_v2 input', '上海房价')
  .click('.gn_search_v2 a')
  // .type('input[action*="/search"] [name=p]', 'github nightmare')
  // .click('form[action*="/search"] [type=submit]')
  .wait('.S_main')
  .evaluate(function () {
    var nodes = document.querySelector('.S_main .search_feed a').innerText;
    console.log(nodes)
    return nodes;
  })

  .end()
  // .then(function(nodes) {
  //  for (var i = 0; i < nodes.length; i++) {
  //    console.log(nodes[i])
  //  }
  // })
  // .then(function (result) {
  //   console.log(result)
  // })
  .catch(function (error) {
    console.error('Search failed:', error);
  });