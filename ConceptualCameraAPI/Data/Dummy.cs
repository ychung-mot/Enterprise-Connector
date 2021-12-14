using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ConceptualCameraAPI.Models;
using System.IO;
using System.Drawing;

namespace ConceptualCameraAPI.Data
{
    public class DummyData
    {
        public Dictionary<int, CameraModel> Cameras = new Dictionary<int, CameraModel>();
        public Dictionary<int, CameraDetailsModel> CameraDetails = new Dictionary<int, CameraDetailsModel>();
        public Dictionary<int, ImageModel> Images = new Dictionary<int, ImageModel>();
        public Dictionary<int, ImageModel> ThumbnailImages = new Dictionary<int, ImageModel>();


        public DummyData()
        {
            // Fill the list of cameras
            Cameras.Add(1, new CameraModel() { Id = 1, Description = "Westshore", Latitude = 48.41368, Longitude = -123.50720 });
            Cameras.Add(2, new CameraModel() { Id = 2, Description = "Duncan", Latitude = 48.40075, Longitude = -123.49732 });
            Cameras.Add(3, new CameraModel() { Id = 3, Description = "Victoria", Latitude = 48.41201, Longitude = -123.41987 });
            Cameras.Add(4, new CameraModel() { Id = 4, Description = "Hope", Latitude = 47.41368, Longitude = -123.12032 });
            Cameras.Add(5, new CameraModel() { Id = 5, Description = "Revelstoke", Latitude = 46.41368, Longitude = 122.50720 });
            Cameras.Add(6, new CameraModel() { Id = 6, Description = "Prince Georgre", Latitude = 46.41368, Longitude = -123.45351 });

            CameraDetails.Add(1, new CameraDetailsModel() { Id = 1, Description = "Westshore", Latitude = 48.41368, Longitude = -123.50720, Devicetype = "APEX 3423", Capabilities="Image|Video|Infra|Sound|Movable", Direction="North", OverlayText="Drive BC - %Date% - %Time%"});
            CameraDetails.Add(2, new CameraDetailsModel() { Id = 2, Description = "Duncan", Latitude = 48.40075, Longitude = -123.49732, Devicetype = "APEX 3424", Capabilities = "Image|Video|Sound|Movable", Direction = "West", OverlayText = "Drive BC - %Date% - %Time%" });
            CameraDetails.Add(3, new CameraDetailsModel() { Id = 3, Description = "Victoria", Latitude = 48.41201, Longitude = -123.41987, Devicetype = "APEX 3423", Capabilities = "Image|Video|Infra|Sound|Static", Direction = "East", OverlayText = "Drive BC - %Date% - %Time%" });
            CameraDetails.Add(4, new CameraDetailsModel() { Id = 4, Description = "Hope", Latitude = 47.41368, Longitude = -123.12032, Devicetype = "APEX 1523", Capabilities = "Image|Static", Direction = "North", OverlayText = "Drive BC - %Date% - %Time%" });
            CameraDetails.Add(5, new CameraDetailsModel() { Id = 5, Description = "Revelstoke", Latitude = 46.41368, Longitude = 122.50720, Devicetype = "ANON 1111", Capabilities = "Image|Video|Infra|Sound|Movable|Zoom", Direction = "North", OverlayText = "%Date% - %Time%" });
            CameraDetails.Add(6, new CameraDetailsModel() { Id = 6, Description = "Prince Georgre", Latitude = 46.41368, Longitude = -123.45351, Devicetype = "LINKSYS D930L", Capabilities = "Image|Video", Direction = "North West", OverlayText = "Front" });

            Random rnd = new Random();

            // Load the images array
            for (int i = 1; i < 7; i++)
            {
                ImageModel _image = new ImageModel();
                ImageModel _thumbImage = new ImageModel();
                DateTime _taken = DateTime.Now - TimeSpan.FromDays((rnd.NextDouble() * 10.0));

                // Load the full image to base64 string
                _image.Taken = _taken;
                _image.Image = Convert.ToBase64String(File.ReadAllBytes(@"Data" + Path.VolumeSeparatorChar + i.ToString() + ".jpg"));
                Images.Add(i, _image);

                _thumbImage.Taken = _taken;
                _thumbImage.Image = Convert.ToBase64String(File.ReadAllBytes(@"Data" + Path.VolumeSeparatorChar + i.ToString() + "-t.jpg"));
                ThumbnailImages.Add(i, _thumbImage);




            }
        }
    }
}
