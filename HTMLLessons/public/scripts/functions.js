function add () {
    const x = 100
    const y = 20
    //    console.log(x+y);
    // document.writeln('Result '+ (x+y) );
    const resultElement = document.getElementById('result')
    resultElement.innerText = 'Result =' + (x + y)
  }

  function sum () {
    const x = parseInt(document.getElementById('firsttxt').value)
    const y = parseInt(document.getElementById('secondtxt').value)
    const resultElement = document.getElementById('result')
    resultElement.innerText = 'Result =' + (x + y)
  }

  function addition (x, y) {
    const resultElement = document.getElementById('result')
    resultElement.innerText = 'Result =' + (parseInt(x) + parseInt(y))
  }
  function printtohunderd()
  {
      for(let i=0;i<100;i++)
      {
          console.log(i);
      }
  }
  function printinreverse()
  {
      for(let i=100;i>=0;i--)
      {
          console.log(i);
      }
  }
  function printevennumbers()
  {
      for(let i=0;i<=100;i++)
      {
          if(i%2===0)
          console.log(i);
      }
  }
//spread operator
  function addnumbers (...value) {
    for(var item in value) {
      console.log(value[item]); //value is the array and item is the index number
    }
}

function yell (name = 'Silly Goose') {
    return `HEY ${name.toUpperCase()}`
  }

  function calculateBill (billAmount, taxRate = 0.13, tipRate = 0.15) {
    console.log('Running Calculate Bill!!')
    console.log('billAmount: ' + billAmount + ' taxRate: ' + taxRate + ' tipRate: ' + tipRate)
    const total = billAmount + billAmount * taxRate + billAmount * tipRate
    return total
  }