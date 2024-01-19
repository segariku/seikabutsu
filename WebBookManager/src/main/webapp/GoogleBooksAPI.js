const btn = document.getElementById("btn");

btn.addEventListener('click', async() => {
    // フォームに入力されたテキストの取得
    const textValue = document.getElementById("formText").value;

    // 書籍検索ができるGoogle Books APIのエンドポイントにフォームから取得したテキストを埋め込む
    const res = await fetch(`https://www.googleapis.com/books/v1/volumes?q=${textValue}`);
    const data = await res.json();
    const bookItem = document.getElementById("bookItem");
    for(let i = 0; i < data.items.length; i++){
        // 例外が起きなければtryブロック内のコードが実行される
        try{
            // JSONデータの取得
            //ISBNコードの取得
            const isbn = data.items[i].volumeInfo.industryIdentifiers[0].identifier;
            // 画像を表示するリンク
            const bookImg = data.items[i].volumeInfo.imageLinks.thumbnail;
            // 本のタイトル
            const bookTitle = data.items[i].volumeInfo.title;
            // 取得したデータを入れるための要素を作成
            const makeElement = document.createElement("div");
            // 要素別に識別できるようにidに数字を埋め込む
            makeElement.setAttribute("id", `bookItem${i}`);
            makeElement.setAttribute("style",'width: 20%; margin-bottom: 15px;')
            // 取得した要素に作成した要素を挿入
            bookItem.appendChild(makeElement);
            // 作成した要素を習得
            const getBookItem = document.getElementById(`bookItem${i}`);
            // APIで取得したデータの分だけHTML要素を作成し、取得した要素にを埋め込む
            const setBookElement = `
                <div class="card mb-4 box-shadow h-100">
                    <img class="card-img-top" src="${bookImg}" alt="No Image" style="background-color: darkgray;width: 100%;height: 250px;object-fit: contain;">
                    <div class="card-body" style="height: 120px">
                          <p class="card-title" style="height: 70px">${bookTitle}</p>
                          <div class="d-flex justify-content-between align-items-center">
                            <a href="BookDetailServlet?isbn=${isbn}" type="button" class="btn btn-sm btn-outline-secondary ms-auto">詳細</a>
                          </div>
                    </div>
                </div>
            `;

            getBookItem.innerHTML = setBookElement;
        }catch(e){
            continue;
        };
    };
});
