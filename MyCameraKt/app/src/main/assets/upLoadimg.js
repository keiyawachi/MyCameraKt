main();

function main(){
  window.onload = ()=>{
    const board = document.querySelector("#imgcanvas");
    const ctx = board.getContext("2d");

    const chara = new Image();
    chara.src = "./loadImage/find_hand.jpg";
    chara.onload = ()=>{
      ctx.drawImage(chara, 0, 0);
    };
  };
}
