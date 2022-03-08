import { ReactComponent as GithubQualqueNome } from 'assets/img/github.svg';
import './styles.css';

function Navbar() {
    return (
        <header>
            <nav className='container'>
                <div className='dsmovie-nav-content'>
                    <h1>DSMovie</h1>
                    <a href='https://github.com/VicenteLamberti'>
                        <div className='dsmovie-contact-container'> 
                            <GithubQualqueNome />
                            <p className='dsmovie-contact-link'>/VicenteLamberti</p>
                        </div>


                    </a>
                </div>
            </nav>
        </header>
    )

}
export default Navbar;