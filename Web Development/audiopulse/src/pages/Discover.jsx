import { useDispatch, useSelector} from 'react-redux'; // these are hooks
import { Error, Loader, SongCard } from "../components";
import { genres } from "../assets/constants";
import { useGetTopChartsQuery } from '../redux/services/shazamCore';
import { selectGenreListId } from '../redux/features/playerSlice';
import { useGetSongsByGenreQuery } from '../redux/services/shazamCore';

const Discover = () => {
    // we can call hooks right at the top of the component
    const dispatch = useDispatch();
    // genreListId is coming from the state
    const { activeSong, isPlaying, genreListId } = useSelector((state) => state.player);

    // {/* we get the actual data which is the result of the API call,
    //     we get the isFetching property which allows us to know if we're currently fetching therefor we can show the loading state 
    //     we get the error property which allows us to know if an error has happened */}
    const { data, isFetching, error } = useGetSongsByGenreQuery(genreListId || 'POP');

    /* add a couple of checks and loading states using redux toolkit */
    // This line keeps crashing the application for some reason ----------------------------------------------------------------
    // if (isFetching) { return <Loader title="Loading Songs..." />; }
    // if (error) { return <Error />; }

    // value is the genre id which is being destructured
    // if the value is equal to the genreListId we get the title of the genre
    const genreTitle = genres.find(({ value }) => value === genreListId)?.title;

    return (
        <div className="flex flex-col">
            <div className="w-full flex justify-between items-center sm:flex-row flex-col mt-4 mb-10">
                <h2 className="font-bold text-3xl text-white text-left">Discover {genreTitle}</h2>
                {/* Add the functionality to send the right genre to our query and fetch the right songs
                    Add event to select onChange so we can dispatch the action of fetching the right genre */}
                <select
                    onChange={(e) => dispatch(selectGenreListId(e.target.value))}
                    value = {genreListId || 'pop'} 
                    className="bg-black text-gray-300 p-3 text-sm rounded-lg 
                                outline-none sm:mt-0 mt-5 bg-opacity-30 shadow-md hover:shadow-sm shadow-[#44112f]"
                >
                    {/* map over the genres */}
                    {genres.map((genre) => <option key={genre.value} value={genre.value}>{genre.title}</option>)}
                </select>
            </div>

            {/* Wrapper for the songs */}
            <div className="flex flex-wrap sm:justify-start justify-center gap-8">
                {data?.map((song, i) => (
                    <SongCard 
                        key={song.key}
                        song={song}
                        activeSong={activeSong}
                        isPlaying={isPlaying}
                        data={data}
                        i={i}
                    />
                ))}
            </div>

        </div>
    );
};

export default Discover;
