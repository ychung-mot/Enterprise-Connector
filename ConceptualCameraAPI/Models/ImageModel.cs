using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ConceptualCameraAPI.Models
{
    public class ImageModel
    {
        public string Image { get; set; }

        public DateTime Taken { get; set; }

        public int xPixel { get; set; }
        public int yPixel { get; set; }
    }
}
