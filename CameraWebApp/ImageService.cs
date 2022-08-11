using System.IO.Compression;

namespace CameraWebApp
{
    public interface IImageService
    {
        Task GetImages();
    }
    public class ImageService : IImageService
    {
        private IImageHttpClient _client;
        private IWebHostEnvironment _env;

        public ImageService(IImageHttpClient client, IWebHostEnvironment env)
        {
            _client = client;
            _env = env;
        }

        public async Task GetImages()
        {
            var response = await _client.GetLatestImages();
            
            using var stream = await response.Content.ReadAsStreamAsync();
            using var mStream = new MemoryStream();

            await stream.CopyToAsync(mStream);

            var filePath = $"{_env.WebRootPath}/images/images.zip";

            File.WriteAllBytes(filePath, mStream.ToArray());

            ZipFile.ExtractToDirectory(filePath, $"{_env.WebRootPath}/images", true);
        }
    }
}
