<section style="font-size: 18px">
    <table border="1" width="700px" style="border-collapse:collapse;">
        <tr>
            <td>Поставщик</td>
            <td style="padding-left: 20px; text-align: center;">
                Иностранное унитарное образовательное предприятие "ЕШКО", РБ<br>
                220118, г.Минск, ул.Шишкина, д.32, пом.8<br>
                р/с BY89BELB30120049020740226000<br>
                в ОАО "Банк БелВЭБ" Минское отделение "Центральное"<br>
                г.Минск, ул.Заславская, 10<br>
                <span style="float: left">BIC BELBBY2X</span><span style="float: right">УНП 101491292</span>
            </td>
        </tr>
    </table>
    <div colspan="2" style="text-align: center; width: 700px">
        <br>СЧЕТ № <strong>${itemId}</strong> от ${billDate?string('dd.MM.yyyy')}
    </div>
    <p>Плательщик </p>
    <p>Адрес </p>
    <p>Основание </p>
    <table border="1" width="700px" style="border-collapse: collapse;">
        <tr>
            <td>Предмет счета</td>
            <td>Кол-во, шт.</td>
            <td>Цена, руб.</td>
            <td>Сумма, руб.</td>
            <td>Ставка НДС, %</td>
            <td>Сумма НДС, руб.</td>
            <td>Всего с НДС, руб.</td>
        </tr>
        <tr>
            <td>${courseName}</td>
            <td>${count}</td>
            <td>${totalPrice - (totalPrice * nds)}</td>
            <td>${totalPrice - (totalPrice * nds)}</td>
            <td>${nds * 100}</td>
            <td>${totalPrice * nds}</td>
            <td>${totalPrice}</td>
        </tr>
        <tr>
            <td>Итого</td>
            <td>${count}</td>
            <td>${totalPrice - (totalPrice * nds)}</td>
            <td>${totalPrice - (totalPrice * nds)}</td>
            <td>${nds * 100}</td>
            <td>${totalPrice * nds}</td>
            <td>${totalPrice}</td>
        </tr>
    </table>
    <p>Сумма НДС: ${totalPrice * nds} рублей</p>
    <p>Всего сумма с НДС: ${totalPrice} рублей</p>
    <p>Счет действителен в течение <strong>трех</strong> банковских дней</p>
    <p>Счет выписал ${userName}</p>
</section>