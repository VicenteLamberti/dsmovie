import {ReactComponent as ArrowQQNome} from 'assets/img/arrow.svg';
import { MoviePage } from 'types/movie';
type Props = {
    page : MoviePage;
    onChange: Function;
}

function Pagination( {page, onChange} : Props ) {
    return (
        <div className="dsmovie-pagination-container">
            <div className="dsmovie-pagination-box">
                <button className="dsmovie-pagination-button" disabled={page.first} onClick={() => {onChange(page.number-1)}}>
                    <ArrowQQNome />
                </button>
                <p>{`${page.number + 1} de ${page.totalPages}`}</p>
                <button className="dsmovie-pagination-button" disabled={page.last} onClick={() => {onChange(page.number + 1)}}>
                    <ArrowQQNome className="dsmovie-flip-horizontal" />
                </button>
            </div>
        </div>
    );
}

export default Pagination;